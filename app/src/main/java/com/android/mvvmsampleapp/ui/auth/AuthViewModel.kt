package com.android.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.android.mvvmsampleapp.data.repository.UserRepository
import com.android.mvvmsampleapp.utils.Coroutines

class AuthViewModel : ViewModel(){

    var email:String? = null
    var password:String? = null

    var authListener: AuthListener? = null

    fun OnLoginButtonClick(view:View)
    {
        authListener?.onStarted()

       if (email.isNullOrEmpty() || password.isNullOrEmpty())
       {
           authListener?.onFailure("Invalid email or Password")

           return
       }


        Coroutines.main {
            val response = UserRepository().userLogin(email!!,password!!)
            if (response.isSuccessful){
                authListener?.onSuccess(response.body()?.user!!)
            }
            else{
                authListener?.onFailure("Error code : ${response.code()}")
            }
        }

          // remoce this line

     //   val loginResponse = UserRepository().userLogin(email!!,password!!)

       //  authListener?.onSucces(loginResponse)


    }

}