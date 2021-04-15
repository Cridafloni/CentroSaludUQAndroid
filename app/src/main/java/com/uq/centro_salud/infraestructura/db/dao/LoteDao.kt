package com.uq.centro_salud.infraestructura.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity
import com.uq.centro_salud.infraestructura.db.Entities.LoteEntity

@Dao
interface LoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: List<LoteEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: LoteEntity)


    @Query("SELECT * FROM lotes")
    fun getArticulos(): LiveData<List<LoteEntity>>

}