package com.example.aksesoris_hp.repository

import com.example.aksesoris_hp.dao.accessorisDao
import com.example.aksesoris_hp.model.accessoris
import kotlinx.coroutines.flow.Flow

class aksesorisRepository(private val accessorisDao: accessorisDao) {
    val allAksesoris:Flow<List<accessoris>> = accessorisDao.getALLaksesoris()
    suspend fun insertAksesoris(accessoris: accessoris){
        accessorisDao.insertAksesoris(accessoris)
    }
    suspend fun deleteAksesoris(accessoris: accessoris){
        accessorisDao.deleteAksesoris(accessoris)
    }
    suspend fun updateAksesoris(accessoris: accessoris){
        accessorisDao.updateAksesoris(accessoris)
    }
}