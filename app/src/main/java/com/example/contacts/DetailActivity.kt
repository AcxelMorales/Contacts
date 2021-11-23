package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Detail contact"
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val index = intent.getStringExtra("ID").toString().toInt()
        val contact = MainActivity.contacts?.get(index)

        val name = findViewById<TextView>(R.id.detailName)
        val company = findViewById<TextView>(R.id.detailCompany)
        val age = findViewById<TextView>(R.id.detailAge)
        val weight = findViewById<TextView>(R.id.detailWeight)
        val telephone = findViewById<TextView>(R.id.detailTelephone)
        val email = findViewById<TextView>(R.id.detailEmail)
        val address = findViewById<TextView>(R.id.detailAddress)

        name.text = contact?.name + " " + contact?.surnames
        company.text = contact?.company
        telephone.text = contact?.telephone
        age.text = contact?.age.toString() + " years"
        weight.text = contact?.weight.toString() + " kg"
        email.text = contact?.email
        address.text = contact?.address
    }

}
