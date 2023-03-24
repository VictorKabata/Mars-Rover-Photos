package com.vickbt.repository.datasources

import com.vickbt.domain.models.Photo
import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.network.ApiService
import com.vickbt.repository.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MarsPhotosRepositoryImpl constructor(private val apiService: ApiService) :
    MarsPhotosRepository {

    override suspend fun fetchMarsPhotos(page: Int): Flow<List<Photo>?> {
        val response=apiService.fetchMarsPhotos().map { it.toDomain() }
        return flowOf(response)
    }

}