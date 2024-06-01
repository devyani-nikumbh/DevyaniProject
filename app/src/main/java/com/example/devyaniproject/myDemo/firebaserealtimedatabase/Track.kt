package com.example.devyaniproject.myDemo.firebaserealtimedatabase


class Track {
    private var id: String? = null
    var trackName: String? = null
        private set
    var rating = 0
        private set

    constructor()
    constructor(id: String?, trackName: String?, rating: Int) {
        this.trackName = trackName
        this.rating = rating
        this.id = id
    }
}