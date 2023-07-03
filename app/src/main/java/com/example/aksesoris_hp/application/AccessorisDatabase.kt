package com.example.aksesoris_hp.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aksesoris_hp.dao.accessorisDao
import com.example.aksesoris_hp.model.accessoris

@Database(entities = [accessoris::class], version = 1, exportSchema = false)
abstract class AccessorisDatabase: RoomDatabase(){
    abstract fun accessorisDao() : accessorisDao

    companion object {
        private var INSTANCE: AccessorisDatabase?=null

        fun getDatabase(context: Context): AccessorisDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccessorisDatabase::class.java,
                    "accessoris_database"
                )
                    .allowMainThreadQueries()
                    .build()

                INSTANCE =instance
                instance
            }
        }
    }
}