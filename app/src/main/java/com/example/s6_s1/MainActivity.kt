package com.example.s6_s1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s6_s1.adapters.ContactAdapter
import com.example.s6_s1.models.Contact


class MainActivity : AppCompatActivity() {
    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView() {
        val rvContact = findViewById<RecyclerView>(R.id.rvContact)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    //Cambiar a que estos contactos se guarden y se recarguen los anadidos
    private fun loadContacts() {
        contacts.add(Contact(1, "Lucho Lopez", "123456"))
        contacts.add(Contact(2, "Nicole Lopez", "123321123"))
        contacts.add(Contact(3, "Ashley Mesta", "123456987"))
        contacts.add(Contact(4, "Kiara Venturo", "123654789"))
        contacts.add(Contact(5, "Leonardo Del Milagro", "955736644"))
    }
}
