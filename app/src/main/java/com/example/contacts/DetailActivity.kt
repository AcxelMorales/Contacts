package com.example.contacts

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem

import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Detail contact"
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        this.index = intent.getStringExtra("ID").toString().toInt()
        this.dataMap()
    }

    private fun dataMap() {
        val contact = MainActivity.contacts?.get(index)

        val name = findViewById<TextView>(R.id.detailName)
        val company = findViewById<TextView>(R.id.detailCompany)
        val age = findViewById<TextView>(R.id.detailAge)
        val weight = findViewById<TextView>(R.id.detailWeight)
        val telephone = findViewById<TextView>(R.id.detailTelephone)
        val email = findViewById<TextView>(R.id.detailEmail)
        val address = findViewById<TextView>(R.id.detailAddress)
        val picture = findViewById<ImageView>(R.id.detailPicture)

        name.text = contact?.name + " " + contact?.surnames
        company.text = contact?.company
        telephone.text = contact?.telephone
        age.text = contact?.age.toString() + " years"
        weight.text = contact?.weight.toString() + " kg"
        email.text = contact?.email
        address.text = contact?.address
        contact?.picture?.let { picture.setImageResource(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.action_delete -> {
                MainActivity.deleteContact(this.index)
                finish()
                true
            }

            R.id.action_edit -> {
                val intent = Intent(this, NewContactActivity::class.java)
                intent.putExtra("ID", this.index.toString())
                startActivity(intent)
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        this.dataMap()
    }

}
