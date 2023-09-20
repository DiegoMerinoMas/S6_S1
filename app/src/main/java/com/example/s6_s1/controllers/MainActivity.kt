package com.example.s6_s1.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s6_s1.R
import com.example.s6_s1.adapters.ContactAdapter
import com.example.s6_s1.adapters.OnItemClickListener
import com.example.s6_s1.database.AppDatabase
import com.example.s6_s1.models.Contact
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson


class MainActivity : AppCompatActivity(), OnItemClickListener {
    fun OnItemClicked(contact: Contact) {
        val intent = Intent(this, ContactActivity::class.java)
        val gson = Gson()
        intent.putExtra("contact", gson.toJson(contact))
    }

    var contacts = List<Contact>()
    var contactAdapter = ContactAdapter(contacts)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume(){
        super.onResume()
        loadContacts()

        val rvContact = findViewById<RecyclerView>(R.id.rvContact)
        contactAdapter = ContactAdapter(contacts, this)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    fun saveContact(){
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)

        val name = etName.text.toString()
        val phone = etPhone.text.toString()

        val contact = Contact(null, name, phone)

        AppDatabase.getInstance(this).contactDao().insert(contact)
    }

    private fun initView() {
        val rvContact = findViewById<RecyclerView>(R.id.rvContact)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }


    private fun loadContacts() {
        contacts=AppDatabase.getInstance(this).contactDao().getAll() as ArrayList<Contact>
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemAdd -> {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
