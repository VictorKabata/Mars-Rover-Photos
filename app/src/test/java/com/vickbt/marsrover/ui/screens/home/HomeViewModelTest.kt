package com.vickbt.marsrover.ui.screens.home

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import com.vickbt.domain.models.Camera
import com.vickbt.domain.models.Photo
import com.vickbt.domain.models.Rover
import com.vickbt.domain.utils.HomeUiState
import com.vickbt.domain.utils.RoversEnum
import com.vickbt.repository.datasources.MarsPhotosRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    // Subject under test
    private lateinit var homeViewModel: HomeViewModel

    // Helpers
    private val marsPhotosRepositoryImpl: MarsPhotosRepositoryImpl = mockk()

    @Before
    fun setup() {
        homeViewModel = HomeViewModel(marsPhotosRepository = marsPhotosRepositoryImpl)
    }

    @Test
    fun `homeUiState data is updated when fetchMarsPhotos is success`() = runTest {
        // Given
        val photos = listOf(
            Photo(
                camera = Camera(
                    fullName = "Front Hazard Avoidance Camera",
                    id = 20,
                    name = "FHAZ",
                    roverId = 5
                ),
                earthDate = "2015-05-30",
                id = 102693,
                imgSrc = "imgSrc",
                sol = 1000,
                rover = Rover(
                    id = 5,
                    landingDate = "2012-08-06",
                    launchDate = "2011-11-26",
                    name = "Curiosity",
                    status = "active"
                )
            )
        )

        val data = flowOf(PagingData.from(photos))

        coEvery { marsPhotosRepositoryImpl.fetchMarsPhotos(roverName = any()) } returns data

        assertEquals(
            expected = HomeUiState(isLoading = true, error = null, data = null),
            actual = homeViewModel.homeUiState.value
        )

        // When
        homeViewModel.fetchMarsPhotos(filterParam = RoversEnum.Curiosity.apiName)

        // Then
        assertNotNull(homeViewModel.homeUiState.value.data)
        assertNull(homeViewModel.homeUiState.value.error)
        assertFalse(homeViewModel.homeUiState.value.isLoading)
    }

    @Test
    fun `homeUiState error is updated when fetchMarsPhotos is failure`() = runTest {

        coEvery { marsPhotosRepositoryImpl.fetchMarsPhotos(roverName = any()) } throws Exception("Custom error")

        val expectedResult = HomeUiState(
            data = null,
            isLoading = false,
            error = "Custom error"
        )

        assertEquals(
            expected = HomeUiState(isLoading = true, error = null, data = null),
            actual = homeViewModel.homeUiState.value
        )

        // when
        homeViewModel.fetchMarsPhotos(filterParam = RoversEnum.Curiosity.apiName)

        // Then
        assertNull(homeViewModel.homeUiState.value.data)
        assertNotNull(homeViewModel.homeUiState.value.error)
        assertFalse(homeViewModel.homeUiState.value.isLoading)

        assertEquals(
            expected = expectedResult,
            actual = homeViewModel.homeUiState.value
        )
    }

    @Test
    fun `roverName is updated with correct value`() {
        // Given
        val filterList = RoversEnum.values().toList()

        assertNull(homeViewModel.roverName.value)

        // When
        filterList.forEachIndexed { index, roversEnum ->
            homeViewModel.filterRover(roverName = roversEnum.apiName)

            assertNotNull(homeViewModel.roverName.value)
            assertEquals(expected = filterList[index].apiName, actual = roversEnum.apiName)
        }
    }

}
