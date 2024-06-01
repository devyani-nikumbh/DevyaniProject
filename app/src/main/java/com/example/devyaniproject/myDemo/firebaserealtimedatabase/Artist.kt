package com.example.devyaniproject.myDemo.firebaserealtimedatabase


class Artist {
    var artistId: String? = null
        private set
    var artistName: String? = null
        private set
    var artistGenre: String? = null
        private set

    constructor()
    constructor(artistId: String?, artistName: String?, artistGenre: String?) {
        this.artistId = artistId
        this.artistName = artistName
        this.artistGenre = artistGenre
    }
}

