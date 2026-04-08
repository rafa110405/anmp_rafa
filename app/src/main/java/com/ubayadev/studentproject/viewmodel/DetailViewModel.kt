package com.ubayadev.studentproject.viewmodel

import android.app.Application
import android.app.DownloadManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ubayadev.studentproject.databinding.FragmentStudentListBinding
import com.ubayadev.studentproject.model.Student

class DetailViewModel(application: Application): AndroidViewModel(application)  {
    val studentLD = MutableLiveData<Student>()
    val TAG:String = "Volley Tag"
    var queue: RequestQueue? = null


    fun fetch(student: Student) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://www.jsonkeeper.com/b/LLMW"
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {Log.d("showvoley", it)},
            {Log.d("showvoley", it.toString())})
        stringRequest.tag = TAG
        queue?.add(stringRequest)
        studentLD.value = student
    }
}

