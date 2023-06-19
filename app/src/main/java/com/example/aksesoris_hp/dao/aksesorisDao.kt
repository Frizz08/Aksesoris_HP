package com.example.aksesoris_hp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.aksesoris_hp.model.aksesoris
import kotlinx.coroutines.flow.Flow

@Dao
interface aksesorisDao {
    @Query("SELECT * FROM aksesoris_table ORDER BY name ASC")
    fun getALLaksesoris(): Flow<List<aksesoris>>

    @Insert
    suspend fun insertAksesoris(aksesoris: aksesoris)

    @Delete
    suspend fun deleteAksesoris(aksesoris: aksesoris)

    @Update fun updateAksesoris(aksesoris: aksesoris)
}