package com.vickbt.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService constructor(private val httpClient: HttpClient) {

    suspend fun fetchMarsPhotos(page: Int = 1, sol: Int = 1000) {
        httpClient.get(urlString = "mars-photos/api/v1/rovers/curiosity/photos") {
            parameter("page", page)
            parameter("sol", sol)
            parameter("api_key", "DEMO_KEY") //ToDo: Change based on build variant
        }
    }

}