package com.uq.centro_salud.infraestructura.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uq.centro_salud.infraestructura.db.Entities.EntradaLoteEntity

@Dao
interface EntradaLoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entradaLoteEntity: EntradaLoteEntity)


    @Query("SELECT * FROM entradas")
    fun getEntradas(): LiveData<List<EntradaLoteEntity>>
}