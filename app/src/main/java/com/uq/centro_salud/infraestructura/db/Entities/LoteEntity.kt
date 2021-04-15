package com.uq.centro_salud.infraestructura.db.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "lotes")
class LoteEntity {


    @PrimaryKey
    @Expose
    var id: Int? = null

    @Expose
    var cantidad_entrada: Int? = null


    @Expose
    var fecha_ingreso: String? = null


    @Expose
    var fecha_vencimiento: String? = null


    @Expose
    var lote_del_producto: String? = null


    @Expose
    var descripcion: String? = null


    @Expose
    var activo: Boolean? = null


    @Expose
    var producto: String? = null


}