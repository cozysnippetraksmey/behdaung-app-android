package dev.raksmey.behdaung.data.remote

import dev.raksmey.behdaung.data.remote.dto.ProductResponse
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}