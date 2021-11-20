package com.example.contacts.classes

class Contact(name: String, surnames: String, company: String, age: Int, weight: Float, address: String, telephone: String, email: String, picture: Int) {

    var name: String = ""
    var surnames: String = ""
    var company: String = ""
    var age: Int = 0
    var weight: Float = 0F
    var address: String = ""
    var telephone: String = ""
    var email: String = ""
    var picture: Int = 0

    init {
        this.name = name
        this.surnames = surnames
        this.company = company
        this.age = age
        this.weight = weight
        this.address = address
        this.telephone = telephone
        this.email = email
        this.picture = picture
    }

}
