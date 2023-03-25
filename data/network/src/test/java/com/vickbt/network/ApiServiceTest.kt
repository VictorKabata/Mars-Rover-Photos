package com.vickbt.network

import com.google.common.truth.Truth.assertThat
import com.vickbt.domain.utils.RoversEnum
import com.vickbt.network.models.curiosityRoverResponse
import com.vickbt.network.models.opportunityRoverResponse
import com.vickbt.network.models.spiritRoverResponse
import com.vickbt.network.utils.MockNasaHttpClient
import io.ktor.client.HttpClient
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ApiServiceTest {

    //Helpers
    private lateinit var mockKtorClient: HttpClient

    //Subject under test
    private lateinit var apiService: ApiService

    @Before
    fun setup() {
        mockKtorClient = MockNasaHttpClient().mockNasaHttpClient
        apiService = ApiService(httpClient = mockKtorClient)
    }

    @After
    fun tearDown() {
        mockKtorClient.close()
    }

    @Test
    fun `fetchMarsPhotos from curiosity success returns data`() = runTest {
        val expectedResult = curiosityRoverResponse

        val response =
            apiService.fetchMarsPhotos(page = 1, roverName = RoversEnum.Curiosity.apiName)

        assertThat(response).isNotNull()
        assertThat(response).isEqualTo(expectedResult)
    }

    @Test
    fun `fetchMarsPhotos from spirit success returns data`() = runTest {
        val expectedResult = spiritRoverResponse

        val response = apiService.fetchMarsPhotos(page = 1, roverName = RoversEnum.Spirit.apiName)

        assertThat(response).isNotNull()
        assertThat(response).isEqualTo(expectedResult)
    }

    @Test
    fun `fetchMarsPhotos from opportunity success returns data`() = runTest {
        val expectedResult = opportunityRoverResponse

        val response =
            apiService.fetchMarsPhotos(page = 1, roverName = RoversEnum.Opportunity.apiName)

        assertThat(response).isNotNull()
        assertThat(response).isEqualTo(expectedResult)
    }

}
