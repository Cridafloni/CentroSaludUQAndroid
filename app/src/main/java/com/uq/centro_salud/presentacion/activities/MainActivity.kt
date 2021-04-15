package com.uq.centro_salud.presentacion.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.uq.centro_salud.R
import com.uq.centro_salud.dominio.base.App
import com.uq.centro_salud.infraestructura.api.RetrofitInstance
import com.uq.centro_salud.infraestructura.db.ApplicationDB
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity
import com.uq.centro_salud.infraestructura.db.Entities.LoteEntity
import com.uq.centro_salud.infraestructura.db.dao.ArticuloDao
import com.uq.centro_salud.infraestructura.db.dao.LoteDao
import com.uq.centro_salud.infraestructura.preferences.Preferences
import com.uq.centro_salud.presentacion.fragments.ArticulosFragment
import com.uq.centro_salud.presentacion.fragments.LoteListFragment
import com.uq.centro_salud.presentacion.fragments.PendienteFragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import kotlinx.android.synthetic.main.activity_main.*

private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

class MainActivity : AppCompatActivity() {


    lateinit var appDB: ApplicationDB
    lateinit var articuloDao: ArticuloDao
    lateinit var loteDao: LoteDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDB = ApplicationDB.getDatabase(this)

        articuloDao = appDB.articuloDao()
        loteDao = appDB.loteDao()



        fetchUsersList("Token " + Preferences.getToken(this))

        setFragment(ArticulosFragment(), "Articulos")


        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_equipos -> {
                    setFragment(ArticulosFragment(), "Articulos")
                }
                R.id.item_lotes -> {
                    setFragment(LoteListFragment(), "Lotes")
                }
                R.id.item_pendiente -> {
                    setFragment(PendienteFragment(), "Pendientes")
                }
            }
            true
        }
    }


    fun fetchUsersList(token: String) {

        val appController = App.create(this)
        val service = RetrofitInstance().getApiService()


        val disposable = service.getallArticles(token)
            .subscribeOn(appController!!.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(appController.subscribeScheduler())
            .concatMap(Function { articulos: List<ArticulosEntity> ->


                articuloDao.insert(articulos)


                Observable.fromIterable(articulos)
            } as Function<List<ArticulosEntity>, Observable<ArticulosEntity>>)

            .concatMap(Function { user: ArticulosEntity ->


                service.getlotes(
                    token,
                    user.registro_invima
                )


            } as Function<ArticulosEntity, Observable<List<LoteEntity>>>)
            .doFinally {

            }
            .subscribe({ posts: List<LoteEntity> ->

                var asd = posts
                loteDao.insert(asd)


            }) { throwable: Throwable? ->

                var a = throwable
            }

        compositeDisposable!!.add(disposable)

    }

    private fun setFragment(fragment: Fragment, texto: String) {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = texto
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }


}