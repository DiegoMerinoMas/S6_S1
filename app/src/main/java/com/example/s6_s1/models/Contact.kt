package com.example.s6_s1.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey (autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "name") val Name: String?,
    @ColumnInfo(name = "phone_number") val phoneNumber: String
)
