package com.vickbt.repository.datasources

/*@RunWith(JUnit4::class)
class MarsPhotosRepositoryImplTests {

    // Test Helpers
    private val mockHttpClient = MockNasaHttpClient()

    private lateinit var mockKtorHttpClient: HttpClient
    private lateinit var apiService: ApiService

    private val TEST_PAGE_SIZE: Int = 15

    // Subject under test
    private lateinit var marsPhotosRepositoryImpl: MarsPhotosRepositoryImpl

    @Before
    fun setup() {
        mockKtorHttpClient = mockHttpClient.mockHttpClient

        apiService = ApiService(httpClient = mockKtorHttpClient)

        marsPhotosRepositoryImpl = MarsPhotosRepositoryImpl(apiService)
    }

    @After
    fun teardown() {
        mockKtorHttpClient.close()
    }

    @Test
    fun `fetchMarsPhotos returns data on http success`() = runTest {
        val expectedData = listOf(
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

        val expectedResult = flowOf(PagingData.from(expectedData))

        val actual = marsPhotosRepositoryImpl.fetchMarsPhotos().first()

        assertEquals(expected = expectedResult.first(), actual = actual)
    }

    @Test
    fun `fetchMarsPhotos throws exception on error`() = runTest {
        mockHttpClient.throwError()

        val expectedException = Error(
            errorCode = "API_KEY_MISSING",
            errorMessage = "No api_key was supplied. Get one at https://api.nasa.gov:443"
        )
        val actualResult = assertFailsWith<Error> {
            marsPhotosRepositoryImpl.fetchMarsPhotos().first()
        }

        assertEquals(expected = expectedException, actual = actualResult)
        assertEquals(expected = expectedException.message, actual = actualResult.message)
    }
}*/
