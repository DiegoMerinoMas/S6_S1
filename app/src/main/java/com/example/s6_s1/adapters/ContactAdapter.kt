package com.example.s6_s1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.s6_s1.R
import com.example.s6_s1.models.Contact

class ContactAdapter(val contacts: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact, parent, false)
        return ContactPrototype(itemView)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bind(contact, itemClickListener)
    }

    override fun getItemCount() = contacts.size

    inner class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val firstNameTextView: TextView = itemView.findViewById(R.id.tvName)
        private val phoneNumberTextView: TextView = itemView.findViewById(R.id.tvPhone)

        fun bind(contact: Contact) {
            firstNameTextView.text = contact.name
            phoneNumberTextView.text = contact.phoneNumber
        }
    }
}


class ContactPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)
    val cvContact = itemView.findViewById<CardView>(R.id.cvContact)

    fun bind(contact: Contact, itemClickListener: OnItemClickListener){
        tvName.text=contact.name
        tvPhone.text=contact.phoneNumber.toString()

        cvContact.setOnClickListener{
            itemClickListener.onItemClick(contact)
        }
    }
}


interface OnItemClickListener{
    fun onItemClick(contact: Contact)
}