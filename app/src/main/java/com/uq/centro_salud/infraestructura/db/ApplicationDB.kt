package com.uq.centro_salud.infraestructura.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity
import com.uq.centro_salud.infraestructura.db.Entities.EntradaLoteEntity
import com.uq.centro_salud.infraestructura.db.Entities.LoteEntity
import com.uq.centro_salud.infraestructura.db.Entities.SalidaLoteEntity
import com.uq.centro_salud.infraestructura.db.dao.ArticuloDao
import com.uq.centro_salud.infraestructura.db.dao.EntradaLoteDao
import com.uq.centro_salud.infraestructura.db.dao.LoteDao
import com.uq.centro_salud.infraestructura.db.dao.SalidaLoteDao

@Database(
    entities = arrayOf(
        ArticulosEntity::class,
        LoteEntity::class,
        SalidaLoteEntity::class,
        EntradaLoteEntity::class
    ),
    version = 4
)
abstract class ApplicationDB : RoomDatabase() {

    abstract fun articuloDao(): ArticuloDao
    abstract fun loteDao(): LoteDao
    abstract fun entradaDao(): EntradaLoteDao
    abstract fun salidaDao(): SalidaLoteDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ApplicationDB? = null

        fun getDatabase(context: Context): ApplicationDB {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ApplicationDB::class.java,
                    "csu_db"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
