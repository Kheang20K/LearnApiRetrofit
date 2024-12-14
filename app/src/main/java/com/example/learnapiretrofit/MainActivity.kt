package com.example.learnapiretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learnapiretrofit.api_helper.RetrofitHelper
import com.example.learnapiretrofit.databinding.ActivityMainBinding
import com.example.learnapiretrofit.service.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initView()
    }

    private fun initView() {
        try {
            val quotesApi = RetrofitHelper.getInstance().create(ApiService::class.java)
            // launching a new coroutine
            CoroutineScope(Dispatchers.Main).launch {
                val result = quotesApi.getQuotes()
                Log.e("Result: ", result.body().toString())
            }
        }catch (e: Exception){
            Log.e("Err",e.message.toString())
        }
    }
}