package com.example.aksesoris_hp.repository

import com.example.aksesoris_hp.dao.aksesorisDao
import com.example.aksesoris_hp.model.aksesoris
import kotlinx.coroutines.flow.Flow

class aksesorisRepository(private val aksesorisDao: aksesorisDao) {
    val allAksesoris:Flow<List<aksesoris>> = aksesorisDao.getALLaksesoris()
    suspend fun insertAksesoris(aksesoris: aksesoris){
        aksesorisDao.insertAksesoris(aksesoris)
    }
    suspend fun deleteAksesoris(aksesoris: aksesoris){
        aksesorisDao.deleteAksesoris(aksesoris)
    }
    suspend fun updateAksesoris(aksesoris: aksesoris){
        aksesorisDao.updateAksesoris(aksesoris)
    }
}