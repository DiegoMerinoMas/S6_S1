package com.example.s6_s1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.s6_s1.models.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            if(INSTANCE == null){
                //SI no existe la BD la crea
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "mycontact.db")
                    .allowMainThreadQueries()
                    .build()
            }
            //Si existe la devuelve
            return INSTANCE as AppDatabase
        }
    }
}