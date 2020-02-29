package com.android.mvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData
import com.android.mvvmsampleapp.data.db.entities.User

interface AuthListener {

    fun onStarted()
   // fun onSucces(loginResponse: LiveData<String>)

    fun onSuccess(user: User)

    fun onFailure(message:String)
}