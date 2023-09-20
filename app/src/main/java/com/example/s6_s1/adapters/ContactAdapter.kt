package com.example.s6_s1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s6_s1.R
import com.example.s6_s1.models.Contact

class ContactAdapter(val contacts: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount() = contacts.size

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val firstNameTextView: TextView = itemView.findViewById(R.id.tvName)
        private val phoneNumberTextView: TextView = itemView.findViewById(R.id.tvPhone)

        fun bind(contact: Contact) {
            firstNameTextView.text = contact.Name
            phoneNumberTextView.text = contact.phoneNumber.toString()
        }
    }
}


class ContactPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)

    fun bind(contact: Contact){
        tvName.text=contact.Name
        tvPhone.text=contact.phoneNumber.toString()
    }

}