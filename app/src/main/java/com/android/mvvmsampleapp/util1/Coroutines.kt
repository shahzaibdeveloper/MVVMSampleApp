package com.android.mvvmsampleapp.util1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines{


    fun<T: Any> ioTheMain(work: suspend  (() -> T?) , callback: ((T?) -> Unit)) =


        CoroutineScope(Dispatchers.Main).launch {

            val data = CoroutineScope(Dispatchers.IO).async rt@{
             return@rt   work()

            }.await()

            callback(data)
        }


}