package ru.rutmitt.internetrequests.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import ru.rutmitt.internetrequests.data.ApiResponse

interface RetrofitNetworkApi {
    @GET(value = "/users")
    suspend fun getUsers(): List<ApiResponse>

    @GET(value = "/users/{id}")
    suspend fun getUserById(@Path("id") id: Int): ApiResponse?
}

private const val NETWORK_BASE_URL = "https://jsonplaceholder.typicode.com"

class RetrofitNetwork : RetrofitNetworkApi {
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val networkApi: RetrofitNetworkApi by lazy {
        Retrofit.Builder()
            .baseUrl(NETWORK_BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(RetrofitNetworkApi::class.java)
    }

    override suspend fun getUsers(): List<ApiResponse> = networkApi.getUsers()

    override suspend fun getUserById(id: Int): ApiResponse? = networkApi.getUserById(id)
}
