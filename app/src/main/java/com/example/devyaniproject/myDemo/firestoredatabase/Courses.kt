package com.example.devyaniproject.myDemo.firestoredatabase

import com.google.firebase.firestore.Exclude
import java.io.Serializable




// we have to implement our modal class
// with serializable so that we can pass
// our object class to new activity on
// our item click of recycler view.
class Courses : Serializable {
    // setter method for our id
    // getter method for our id
    // we are using exclude because
    // we are not saving our id
    @Exclude
    var id: String? = null

    // getter methods for all variables.
    // variables for storing our data.
    var courseName: String? = null

    // setter method for all variables.
    var courseDescription: String? = null
    var courseDuration: String? = null

    constructor()

    // Constructor for all variables.
    constructor(courseName: String?, courseDescription: String?, courseDuration: String?) {
        this.courseName = courseName
        this.courseDescription = courseDescription
        this.courseDuration = courseDuration
    }

}



