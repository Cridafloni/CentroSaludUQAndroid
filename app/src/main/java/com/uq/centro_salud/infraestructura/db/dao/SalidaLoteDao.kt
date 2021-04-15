package com.uq.centro_salud.infraestructura.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.uq.centro_salud.infraestructura.db.Entities.SalidaLoteEntity

@Dao
interface SalidaLoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entradaLoteEntity: SalidaLoteEntity)
}