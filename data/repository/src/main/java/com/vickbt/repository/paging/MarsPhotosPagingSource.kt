package com.vickbt.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vickbt.domain.models.Photo
import com.vickbt.network.ApiService
import com.vickbt.repository.mappers.toDomain
import java.io.IOException

class MarsPhotosPagingSource constructor(private val apiService: ApiService) :
    PagingSource<Int, Photo>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1
        val pageSize = params.loadSize

        val result = apiService.fetchMarsPhotos(page = page)

        return try {
            LoadResult.Page(
                data = result.map { it.toDomain() },
                nextKey = if (result.isEmpty()) null else page.plus(1),
                prevKey = if (page == 1) null else page.minus(1)
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}