package com.example.learnapiretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learnapiretrofit.api_helper.RetrofitHelper
import com.example.learnapiretrofit.api_helper.RetrofitHelper.getApiService
import com.example.learnapiretrofit.databinding.ActivityMainBinding
import com.example.learnapiretrofit.service.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        try {
            CoroutineScope(Dispatchers.Main).launch {
                val result = getApiService().getUser()
                result.body()?.forEach { data ->
                    binding.name.text = data.name
                    binding.age.text = data.age
                    binding.status.text = data.status
                    data.address?.forEach { addressData ->
                        binding.address.text = addressData.province + "\n" + addressData.distric + "\n" + addressData.village
                    }
                }

            }
        }catch (e: Exception){
            Log.e("Err",e.message.toString())
        }
    }
}