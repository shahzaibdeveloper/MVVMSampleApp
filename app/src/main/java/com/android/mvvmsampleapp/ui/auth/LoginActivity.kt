package com.android.mvvmsampleapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.mvvmsampleapp.R
import com.android.mvvmsampleapp.data.db.entities.User
import com.android.mvvmsampleapp.databinding.ActivityLoginBinding
import com.android.mvvmsampleapp.utils.toast

class LoginActivity : AppCompatActivity(),AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        val ViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = ViewModel
        ViewModel.authListener = this

    }

    override fun onStarted() {
        toast("Login started")
    }

    override fun onSuccess(user: User) {       //loginResponse: LiveData<String>
       toast("Login Success")

      //  loginResponse.observe(this, Observer {
            toast("${user.user_email} is logged in")
        //})
    }

    override fun onFailure(message: String) {
       toast(message)
    }
}
