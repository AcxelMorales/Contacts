package com.example.contacts.adapters

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import com.example.contacts.R

import com.example.contacts.classes.Contact

class CustomAdapter(var context: Context, items: ArrayList<Contact>): BaseAdapter() {

    private var itemsClass: ArrayList<Contact>? = null

    init {
        this.itemsClass = items
    }

    override fun getCount(): Int {
        return this.itemsClass?.size!!
    }

    override fun getItem(position: Int): Any {
        return this.itemsClass?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder?
        var view: View? = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.template_contacts, null)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as? ViewHolder
        }

        val item = getItem(position) as Contact

        holder?.name?.text = item.name + " " + item.surnames
        holder?.img?.setImageResource(item.picture)
        holder?.company?.text = item.company

        return view!!
    }

    private class ViewHolder(view: View) {

        var name: TextView? = null
        var img: ImageView? = null
        var company: TextView? = null

        init {
            this.name = view.findViewById(R.id.textName)
            this.img = view.findViewById(R.id.pictureContact)
            this.company = view.findViewById(R.id.textWork)
        }

    }

}
