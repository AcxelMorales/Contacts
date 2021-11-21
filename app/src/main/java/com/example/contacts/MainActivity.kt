package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import android.os.Bundle

import android.content.Intent

import android.view.Menu
import android.view.MenuItem

import android.widget.ListView

import com.example.contacts.adapters.CustomAdapter
import com.example.contacts.classes.Contact

class MainActivity : AppCompatActivity() {

    var contacts: ArrayList<Contact>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        contacts = ArrayList()
        contacts?.add(Contact("Acxel", "Morales", "Endcom", 24, 76.0F, "Estado de México", "5566778899", "acxel@endcom.mx", R.drawable.acxel))
        contacts?.add(Contact("Linus", "Torvalds", "Linux", 24, 76.0F, "Estado de México", "5566778899", "acxel@endcom.mx", R.drawable.foto_01))
        contacts?.add(Contact("Ryan", "Dahl", "Node JS & Deno", 24, 76.0F, "Estado de México", "5566778899", "acxel@endcom.mx", R.drawable.foto_02))
        contacts?.add(Contact("John", "Doe", "Microsoft", 24, 76.0F, "Estado de México", "5566778899", "acxel@endcom.mx", R.drawable.foto_03))
        contacts?.add(Contact("Hedy", "Lamar", "Google", 24, 76.0F, "Estado de México", "5566778899", "acxel@endcom.mx", R.drawable.foto_04))
        contacts?.add(Contact("Rózsa", "Peter", "IBM", 24, 76.0F, "Estado de México", "5566778899", "acxel@endcom.mx", R.drawable.foto_05))
        contacts?.add(Contact("Grace", "Murray", "ASUS", 24, 76.0F, "Estado de México", "5566778899", "acxel@endcom.mx", R.drawable.foto_06))

        val list = findViewById<ListView>(R.id.listContact)
        val adapter = CustomAdapter(this, contacts!!)

        list.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.action_new_contact -> {
                val intent = Intent(this, NewContactActivity::class.java)
                startActivity(intent)
                true
            } else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

}
