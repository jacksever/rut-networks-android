package ru.rutmitt.internetrequests.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.rutmitt.internetrequests.databinding.ActivityMainBinding
import ru.rutmitt.internetrequests.network.ktor.KtorNetwork
import ru.rutmitt.internetrequests.network.ktor.KtorNetworkApi
import ru.rutmitt.internetrequests.network.retrofit.RetrofitNetwork
import ru.rutmitt.internetrequests.network.retrofit.RetrofitNetworkApi

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var _retrofitApi: RetrofitNetworkApi? = null
    private val retrofitApi get() = _retrofitApi!!

    private var _ktorApi: KtorNetworkApi? = null
    private val ktorApi get() = _ktorApi!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _ktorApi = KtorNetwork()
        _retrofitApi = RetrofitNetwork()
        
        /* Requesting URL: https://jsonplaceholder.typicode.com/users */

        binding.retrofit.setOnClickListener {
            lifecycleScope.launch {
                val users = retrofitApi.getUsers()
                binding.userList.adapter = ApiResponseAdapter(users)
            }
        }

        binding.ktor.setOnClickListener {
            lifecycleScope.launch {
                val users = ktorApi.getUsers()
                binding.userList.adapter = ApiResponseAdapter(users)
            }
        }

        binding.archive.setOnClickListener {
            (binding.userList.adapter as ApiResponseAdapter).setData(emptyList())
        }
    }
}
