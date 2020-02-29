package com.android.mvvmsampleapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0

@Entity
data class User (


  var user_id : Int? = null,

  var username: String? = null,

  var user_email:String? = null,

  var user_pass:String? = null,

  var user_phone:String? = null

){
   @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}