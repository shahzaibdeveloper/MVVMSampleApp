package com.android.mvvmsampleapp.data.repository


import com.android.mvvmsampleapp.data.network.MyApi
import com.android.mvvmsampleapp.data.network.responses.AuthResponse

import retrofit2.Response

class UserRepository {

  suspend   fun userLogin(email:String,password:String) :  Response<AuthResponse>{//LiveData<String> // suspend remove
     //    val loginResponse = MutableLiveData<String>()

       //  MyApi().userLogin(email,password)
         //    .enqueue(object :Callback<ResponseBody>{
           //      override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
             //        loginResponse.value = t.message
            //     }

              //   override fun onResponse(
                //     call: Call<ResponseBody>,
              //       response: Response<ResponseBody>
              //   ) {

                //     if (response.isSuccessful){
              //           loginResponse.value = response.body()?.string()
              //       }else{
                //         loginResponse.value = response.errorBody()?.string()
               //      }

             //    }

          //   })

       //  return loginResponse


         return MyApi().userLogin(email,password)

     }






 }