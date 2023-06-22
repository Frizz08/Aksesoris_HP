package com.example.aksesoris_hp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.aksesoris_hp.model.accessoris
import kotlinx.coroutines.flow.Flow

@Dao
interface accessorisDao {
    @Query("SELECT * FROM accessoris_table ORDER BY name ASC")
    fun getALLaksesoris(): Flow<List<accessoris>>

    @Insert
    suspend fun insertAksesoris(accessoris: accessoris)

    @Delete
    suspend fun deleteAksesoris(accessoris: accessoris)

    @Update fun updateAksesoris(accessoris: accessoris)
}