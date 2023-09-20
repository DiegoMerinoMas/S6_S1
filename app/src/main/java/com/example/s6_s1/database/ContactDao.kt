package com.example.s6_s1.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.s6_s1.models.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contact WHERE uid IN (:contactIds)")
    fun loadAllByIds(contactIds: IntArray): List<Contact>

    @Insert
    fun insertAll(vararg contacts: Contact)

    @Delete
    fun delete(contact: Contact)
}