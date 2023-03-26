package com.vickbt.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vickbt.domain.models.Photo
import com.vickbt.domain.utils.NetworkResultState
import com.vickbt.network.ApiService
import com.vickbt.repository.mappers.toDomain
import com.vickbt.repository.utils.safeApiCall
import kotlinx.coroutines.flow.first

class MarsPhotosPagingSource constructor(
    private val apiService: ApiService,
    private val roverName: String?
) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1

        val result =
            safeApiCall { apiService.fetchMarsPhotos(page = page, roverName = roverName) }.first()

        return when (result) {
            is NetworkResultState.Failure -> {
                LoadResult.Error(result.exception.cause!!)
            }
            is NetworkResultState.Success -> {
                LoadResult.Page(
                    data = result.data.map { it.toDomain() },
                    nextKey = if (result.data.isEmpty()) null else page.plus(1),
                    prevKey = if (page == 1) null else page.minus(1)
                )
            }
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
