package com.example.aksesoris_hp.application

import android.app.Application
import com.example.aksesoris_hp.dao.accessorisDao
import com.example.aksesoris_hp.repository.aksesorisRepository

class AccessorisApp: Application() {
    val database by lazy { AccessorisDatabase.getDatabase(this) }
    val repository by lazy { aksesorisRepository(database.accessorisDao()) }
}