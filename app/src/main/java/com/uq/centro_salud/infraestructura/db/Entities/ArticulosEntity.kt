package com.uq.centro_salud.infraestructura.db.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import java.io.Serializable


@Entity(tableName = "articulos")
class ArticulosEntity : Serializable {


    @Expose
    @PrimaryKey
    lateinit var registro_invima: String

    @Expose
    var nombre: String? = null


    @Expose
    var proveedor: String? = null


    @Expose
    var fecha_registro: String? = null


    @Expose
    var descripcion: String? = null


    @Expose
    var material: String? = null


    @Expose
    var presentacion: String? = null


    @Expose
    var tipo: String? = null


}