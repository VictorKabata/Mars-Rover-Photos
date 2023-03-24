package com.vickbt.network

import com.vickbt.network.models.MarsPhotosDto
import com.vickbt.network.models.PhotoDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService constructor(private val httpClient: HttpClient) {

    suspend fun fetchMarsPhotos(
        page: Int = 1,
        sol: Int = 1000,
        roverName: String = "curiosity"
    ): List<PhotoDto> {
        return httpClient.get(urlString = "mars-photos/api/v1/rovers/$roverName/photos") {
            parameter("page", page)
            parameter("sol", sol)
        }.body<MarsPhotosDto>().photosDto
    }

}