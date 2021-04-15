package com.uq.centro_salud.infraestructura.db.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "salidas")
class SalidaLoteEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Expose
    var cantidad_salida: Int? = null

    @Expose
    var descripcion: String? = null

    @Expose
    var producto: Int? = null
}