package com.example.devyaniproject.myDemo.dataStorage.sqlite

class Contact {
    var iD :Int= 0
    var name: String? = null
    var phoneNumber: String? = null

    constructor()
    constructor(id: Int, name: String?, _phone_number: String?) {
        iD = id
        this.name = name
        phoneNumber = _phone_number
    }

    constructor(name: String?, _phone_number: String?) {
        this.name = name
        phoneNumber = _phone_number
    }
}