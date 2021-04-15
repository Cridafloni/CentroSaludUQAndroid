package com.uq.centro_salud.presentacion.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.uq.centro_salud.R
import com.uq.centro_salud.infraestructura.db.ApplicationDB
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity
import com.uq.centro_salud.infraestructura.db.Entities.EntradaLoteEntity
import com.uq.centro_salud.infraestructura.db.Entities.SalidaLoteEntity
import com.uq.centro_salud.infraestructura.db.dao.EntradaLoteDao
import com.uq.centro_salud.infraestructura.db.dao.SalidaLoteDao
import com.uq.centro_salud.presentacion.others.SwwtAlert
import kotlinx.android.synthetic.main.activity_envio_registro.*


class EnvioRegistroActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    var tipo = arrayOf("Entrada articulos", "Salida articulos")


    lateinit var appDB: ApplicationDB
    lateinit var entradaDao: EntradaLoteDao
    lateinit var salidaDao: SalidaLoteDao
    var entrada = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_envio_registro)


        appDB = ApplicationDB.getDatabase(this)


        appDB = ApplicationDB.getDatabase(this)
        salidaDao = appDB.salidaDao()
        entradaDao = appDB.entradaDao()

        var alert = SwwtAlert(this@EnvioRegistroActivity)

        var producto: ArticulosEntity =
            intent.getSerializableExtra("articulo") as ArticulosEntity

        textView_tipo_envio.text = producto.tipo
        textView_nombreproducto_envio.text = producto.nombre
        textView_presentacion_envio.text = producto.presentacion
        textView_proveedorproducto_envio.text = producto.proveedor
        textView_registroproducto_envio.text = producto.registro_invima
        spinner.onItemSelectedListener = this

        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, tipo)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = aa

        button_enviar_info.setOnClickListener {
            if (editextCantidad.text.isEmpty()) {
                alert.showMessage(
                    "Error",
                    "debe seleccionar la cantidad",
                    SweetAlertDialog.ERROR_TYPE
                )
            } else {
                enviar()

            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        entrada = position == 0
    }

    private fun enviar() {
        if (entrada) {
            var entradaLoteEntity = EntradaLoteEntity()
            entradaLoteEntity.cantidad_entrante = editextCantidad.text.toString().toInt()
            entradaLoteEntity.descripcion = editextDescripcion.text.toString()
            entradaLoteEntity.producto = 1
            entradaDao.insert(entradaLoteEntity)
            saveNotification()
        } else {
            var salidaEntity = SalidaLoteEntity()
            salidaEntity.cantidad_salida = editextCantidad.text.toString().toInt()
            salidaEntity.descripcion = editextDescripcion.text.toString()
            salidaEntity.producto = 1
            salidaDao.insert(salidaEntity)
            saveNotification()
        }


    }


    private fun saveNotification() {
        SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("Proceso exitoso!")
            .setContentText("Este registro se almacenó localmente")
            .setConfirmText("Aceptar")
            .setConfirmClickListener { sDialog ->
                finish()
            }
            .show()
    }
}