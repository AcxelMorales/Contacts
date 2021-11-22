package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem

import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.widget.Toolbar

import com.example.contacts.classes.Contact

class NewContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "New contact"
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_new_contact, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.action_add_contact -> {
                val name = findViewById<EditText>(R.id.detailName)
                val surname = findViewById<EditText>(R.id.detailSurname)
                val company = findViewById<EditText>(R.id.detailCompany)
                val years = findViewById<EditText>(R.id.detailAge)
                val weight = findViewById<EditText>(R.id.detailWeight)
                val telephone = findViewById<EditText>(R.id.detailTelephone)
                val email = findViewById<EditText>(R.id.detailEmail)
                val address = findViewById<EditText>(R.id.detailAddress)

                var fields = ArrayList<String>()

                fields.add(name.text.toString())
                fields.add(surname.text.toString())
                fields.add(company.text.toString())
                fields.add(years.text.toString())
                fields.add(weight.text.toString())
                fields.add(telephone.text.toString())
                fields.add(email.text.toString())
                fields.add(address.text.toString())

                var flag = 0

                for (e in fields) {
                    if (e.isNullOrEmpty()) flag++
                }

                if (flag > 0) {
                    Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                } else {
                    MainActivity.addContact(Contact(
                        name.text.toString(),
                        surname.text.toString(),
                        company.text.toString(),
                        years.text.toString().toInt(),
                        weight.text.toString().toFloat(),
                        address.text.toString(),
                        telephone.text.toString(),
                        email.text.toString(),
                        R.drawable.foto_01
                    ))

                    finish()
                }

                true
            } else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

}
