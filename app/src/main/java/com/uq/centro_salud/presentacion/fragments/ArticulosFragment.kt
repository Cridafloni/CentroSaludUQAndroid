package com.uq.centro_salud.presentacion.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import co.com.sura.regresoseguroapp.ui.adapter.ArticulosAdapter
import com.uq.centro_salud.R
import com.uq.centro_salud.infraestructura.db.ApplicationDB
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity
import com.uq.centro_salud.presentacion.activities.EnvioRegistroActivity
import com.uq.centro_salud.presentacion.adapter.OnItemClick
import kotlinx.android.synthetic.main.fragment_articulos.view.*


class ArticulosFragment : Fragment(), OnItemClick {


    lateinit var content: View
    lateinit var adapterArticulos: ArticulosAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        content = inflater.inflate(R.layout.fragment_articulos, container, false)
        adapterArticulos = ArticulosAdapter(ArrayList(), activity!!, this)
        content.recycler_articulos.adapter = adapterArticulos
        getArticulos()



        return content
    }


    private fun getArticulos() {
        ApplicationDB.getDatabase(activity!!).articuloDao()
            .getArticulos().observe(viewLifecycleOwner, object : Observer<List<ArticulosEntity>> {
                override fun onChanged(t: List<ArticulosEntity>?) {
                    var a = t as ArrayList
                    adapterArticulos.items.clear()
                    adapterArticulos.items = a
                    adapterArticulos.notifyDataSetChanged()
                }
            })
    }

    override fun onItemClick(articulosEntity: ArticulosEntity) {
        val intent = Intent(activity, EnvioRegistroActivity::class.java)
        intent.putExtra("articulo", articulosEntity)
        startActivity(intent)
    }


}