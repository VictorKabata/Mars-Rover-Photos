package com.vickbt.network.utils

import com.vickbt.network.models.CameraDto
import com.vickbt.network.models.ErrorResponseDto
import com.vickbt.network.models.PhotoDto
import com.vickbt.network.models.RoverDto

//region Curiosity Rover Response
val curiosityRoverHttpResponse = """
    {
        "photos": [
            {
                "id": 102693,
                "sol": 1000,
                "camera": {
                    "id": 20,
                    "name": "FHAZ",
                    "rover_id": 5,
                    "full_name": "Front Hazard Avoidance Camera"
                },
                "img_src": "imgSrc",
                "earth_date": "2015-05-30",
                "rover": {
                    "id": 5,
                    "name": "Curiosity",
                    "landing_date": "2012-08-06",
                    "launch_date": "2011-11-26",
                    "status": "active"
                }
            }
        ]
    }
""".trimIndent()

val curiosityRoverResponse = listOf<PhotoDto>(
    PhotoDto(
        cameraDto = CameraDto(
            fullName = "Front Hazard Avoidance Camera",
            id = 20,
            name = "FHAZ",
            roverId = 5
        ),
        earthDate = "2015-05-30",
        id = 102693,
        imgSrc = "imgSrc",
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
//endregion

//region Spirit Rover Response
val spiritRoverHttpResponse = """
    {
        "photos": [
            {
                "id": 301536,
                "sol": 1000,
                "camera": {
                    "id": 29,
                    "name": "NAVCAM",
                    "rover_id": 7,
                    "full_name": "Navigation Camera"
                },
                "img_src": "imgSrc",
                "earth_date": "2006-10-27",
                "rover": {
                    "id": 7,
                    "name": "Spirit",
                    "landing_date": "2004-01-04",
                    "launch_date": "2003-06-10",
                    "status": "complete"
                }
            }
        ]
    }
""".trimIndent()

val spiritRoverResponse = listOf<PhotoDto>(
    PhotoDto(
        cameraDto = CameraDto(
            fullName = "Navigation Camera",
            id = 29,
            name = "NAVCAM",
            roverId = 7
        ),
        earthDate = "2006-10-27",
        id = 301536,
        sol = 1000,
        imgSrc = "imgSrc",
        roverDto = RoverDto(
            id = 7,
            landingDate = "2004-01-04",
            launchDate = "2003-06-10",
            name = "Spirit",
            status = "complete"
        )
    )
)
//endregion

//region Opportunity Rover Response
val opportunityRoverHttpResponse = """
    {
        "photos": [
            {
                "id": 141044,
                "sol": 1000,
                "camera": {
                    "id": 16,
                    "name": "NAVCAM",
                    "rover_id": 6,
                    "full_name": "Navigation Camera"
                },
                "img_src": "imgSrc",
                "earth_date": "2006-11-17",
                "rover": {
                    "id": 6,
                    "name": "Opportunity",
                    "landing_date": "2004-01-25",
                    "launch_date": "2003-07-07",
                    "status": "complete"
                }
            }
        ]
    }
""".trimIndent()

val opportunityRoverResponse = listOf<PhotoDto>(
    PhotoDto(
        cameraDto = CameraDto(
            fullName = "Navigation Camera",
            id = 16,
            name = "NAVCAM",
            roverId = 6
        ),
        earthDate = "2006-11-17",
        id = 141044,
        sol = 1000,
        imgSrc = "imgSrc",
        roverDto = RoverDto(
            id = 6,
            landingDate = "2004-01-25",
            launchDate = "2003-07-07",
            name = "Opportunity",
            status = "complete"
        )
    )
)
//endregion

//region Error Response
val errorHttpResponse = """
    {
        "error": {
            "code": "API_KEY_MISSING",
            "message": "No api_key was supplied. Get one at https://api.nasa.gov:443"
        }
    } 
""".trimIndent()

val errorResponse = ErrorResponseDto(
    errorCode = "API_KEY_MISSING",
    errorMessage = "No api_key was supplied. Get one at https://api.nasa.gov:443"
)
//endregion
