package com.vickbt.repository.paging

import androidx.paging.PagingSource
import com.google.common.truth.Truth.assertThat
import com.vickbt.domain.models.Camera
import com.vickbt.domain.models.Photo
import com.vickbt.domain.models.Rover
import com.vickbt.domain.utils.RoversEnum
import com.vickbt.network.ApiService
import com.vickbt.repository.utils.MockNasaHttpClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MarsPhotosPagingSourceTests {

    // Test Helpers
    private val mockHttpClient = MockNasaHttpClient()

    private lateinit var mockKtorHttpClient: HttpClient
    private lateinit var apiService: ApiService

    private val TEST_PAGE_SIZE: Int = 15

    // Subject under test
    private lateinit var marsPhotosPagingSource: MarsPhotosPagingSource

    @Before
    fun setup() {
        mockKtorHttpClient = mockHttpClient.mockNasaHttpClient

        apiService = ApiService(httpClient = mockKtorHttpClient)

        marsPhotosPagingSource =
            MarsPhotosPagingSource(
                apiService = apiService,
                roverName = RoversEnum.Curiosity.apiName
            )
    }

    @After
    fun teardown() {
        mockKtorHttpClient.close()
    }

    @Test
    fun `load returns success on http success`() = runTest {
        val expectedData = listOf<Photo>(
            Photo(
                camera = Camera(
                    fullName = "Front Hazard Avoidance Camera",
                    id = 20,
                    name = "FHAZ",
                    roverId = 5
                ),
                earthDate = "2015-05-30",
                id = 102693,
                imgSrc = "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
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

        val expectedResult = PagingSource.LoadResult.Page(
            data = expectedData,
            prevKey = null,
            nextKey = 2
        )

        val actual = marsPhotosPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = 1,
                loadSize = TEST_PAGE_SIZE,
                placeholdersEnabled = false
            )
        )

        assertThat(expectedResult).isEqualTo(actual)
    }

    @Test
    fun `load returns error on http error`() = runTest {
        mockHttpClient.throwError()

        val error = Exception()
        val expectedResult = PagingSource.LoadResult.Error<Int, Photo>(error)

        val result = marsPhotosPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = 1,
                loadSize = TEST_PAGE_SIZE,
                placeholdersEnabled = false
            )
        )

        assertThat(expectedResult).isEqualTo(result)
    }


}
