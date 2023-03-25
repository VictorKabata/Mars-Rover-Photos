package com.vickbt.repository.mappers

import com.google.common.truth.Truth.assertThat
import com.vickbt.domain.models.Camera
import com.vickbt.domain.models.ErrorResponse
import com.vickbt.domain.models.Photo
import com.vickbt.domain.models.Rover
import com.vickbt.network.models.CameraDto
import com.vickbt.network.models.ErrorResponseDto
import com.vickbt.network.models.PhotoDto
import com.vickbt.network.models.RoverDto
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DtoToDomainTest {

    @Test
    fun `CameraDto toDomain returns correct data`() {
        val expectedResult = listOf<Photo>(
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

        val actual = listOf<PhotoDto>(
            PhotoDto(
                cameraDto = CameraDto(
                    fullName = "Front Hazard Avoidance Camera",
                    id = 20,
                    name = "FHAZ",
                    roverId = 5
                ),
                earthDate = "2015-05-30",
                id = 102693,
                imgSrc = "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
                sol = 1000,
                roverDto = RoverDto(
                    id = 5,
                    landingDate = "2012-08-06",
                    launchDate = "2011-11-26",
                    name = "Curiosity",
                    status = "active"
                )
            )
        )

        assertThat(actual.map { it.toDomain() }).isEqualTo(expectedResult)
    }

    @Test
    fun `PhotoDto toDomain returns correct data`() {
        val expectedResult = Photo(
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

        val actual = PhotoDto(
            cameraDto = CameraDto(
                fullName = "Front Hazard Avoidance Camera",
                id = 20,
                name = "FHAZ",
                roverId = 5
            ),
            earthDate = "2015-05-30",
            id = 102693,
            imgSrc = "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
            sol = 1000,
            roverDto = RoverDto(
                id = 5,
                landingDate = "2012-08-06",
                launchDate = "2011-11-26",
                name = "Curiosity",
                status = "active"
            )
        )

        assertThat(actual.toDomain()).isEqualTo(expectedResult)
    }

    @Test
    fun `RoverDto toDomain returns correct data`() {
        val expectedResult = Rover(
            id = 5,
            landingDate = "2012-08-06",
            launchDate = "2011-11-26",
            name = "Curiosity",
            status = "active"
        )

        val result = RoverDto(
            id = 5,
            landingDate = "2012-08-06",
            launchDate = "2011-11-26",
            name = "Curiosity",
            status = "active"
        )
    }

    @Test
    fun `ErrorResponseDto toDomain returns correct data`() {
        val expectedResult = ErrorResponse(
            errorCode = "API_KEY_MISSING",
            errorMessage = "No api_key was supplied. Get one at https://api.nasa.gov:443"
        )

        val actual = ErrorResponseDto(
            errorCode = "API_KEY_MISSING",
            errorMessage = "No api_key was supplied. Get one at https://api.nasa.gov:443"
        )

        assertThat(actual.toDomain()).isEqualTo(expectedResult)
    }

}
