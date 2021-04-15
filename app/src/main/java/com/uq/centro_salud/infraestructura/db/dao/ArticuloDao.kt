package com.uq.centro_salud.infraestructura.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity

@Dao
interface ArticuloDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: List<ArticulosEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: ArticulosEntity)

    @Query("SELECT * FROM articulos")
    fun getArticulos(): LiveData<List<ArticulosEntity>>
}