package com.example.s6_s1.controllers

//import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.s6_s1.R
import com.example.s6_s1.database.AppDatabase
import com.example.s6_s1.models.Contact
import com.google.gson.Gson

class ContactActivity: AppCompatActivity(){
    private lateinit var contact: Contact
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        loadContact()
    }

    private fun loadContact() {
        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)

        val gson = Gson()
        val stringObj = intent.getStringExtra("contact")

        contact = gson.fromJson(stringObj, Contact::class.java)?:
        Contact(null, "", "")

        if(contact.uid!=null){
            etName.setText(contact.name)
            etPhone.setText(contact.phoneNumber)
        }
        else{
            contact = Contact(null, "", "")
        }
    }

    private fun saveContact(){
        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)

        //val name = etName.text.toString()
        //val phone = etPhone.text.toString()

        contact.name = etName.text.toString()
        contact.phoneNumber = etPhone.text.toString()

        if(contact.uid==null){
            AppDatabase.getInstance(this).contactDao().insert(contact)
        }
        else {
            AppDatabase.getInstance(this).contactDao().update(contact)
        }
        finish()
    }

    private fun deleteContact(){
        AppDatabase.getInstance(this).contactDao().delete(contact)
        finish()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.contact_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemSave -> {
                saveContact()
                true
            }
            R.id.itemDelete -> {
                deleteContact()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}