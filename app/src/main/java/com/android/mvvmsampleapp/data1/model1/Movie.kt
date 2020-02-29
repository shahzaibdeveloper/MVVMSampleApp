package com.android.mvvmsampleapp.data1.model1


import com.google.gson.annotations.SerializedName

data class Movie(
    val progress: Int,
    val bio: String,
    val createdby: String,
    val firstappearance: String,
    val imageurl: String,
    val name: String,
    val publisher: String,
    val realname: String,
    val team: String
)