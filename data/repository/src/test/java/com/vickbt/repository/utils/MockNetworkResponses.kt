package com.vickbt.network.models

//region Curiosity Rover Response
const val curiosityRoverHttpResponse = """
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
            "img_src": "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
            "earth_date": "2015-05-30",
            "rover": {
                "id": 5,
                "name": "Curiosity",
                "landing_date": "2012-08-06",
                "launch_date": "2011-11-26",
                "status": "active"
            }
        },
        {
            "id": 102693,
            "sol": 1000,
            "camera": {
                "id": 20,
                "name": "FHAZ",
                "rover_id": 5,
                "full_name": "Front Hazard Avoidance Camera"
            },
            "img_src": "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
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
"""

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
        imgSrc = "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
        sol = 1000,
        roverDto = RoverDto(
            id = 5,
            landingDate = "2012-08-06",
            launchDate = "2011-11-26",
            name = "Curiosity",
            status = "active"
        )
    ),
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
//endregion

//region Spirit Rover Response
const val spiritRoverHttpResponse = """
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
            "img_src": "http://mars.nasa.gov/mer/gallery/all/2/n/1000/2N215136972EDNAS00P1585L0M1-BR.JPG",
            "earth_date": "2006-10-27",
            "rover": {
                "id": 7,
                "name": "Spirit",
                "landing_date": "2004-01-04",
                "launch_date": "2003-06-10",
                "status": "complete"
            }
        },
        {
            "id": 301536,
            "sol": 1000,
            "camera": {
                "id": 29,
                "name": "NAVCAM",
                "rover_id": 7,
                "full_name": "Navigation Camera"
            },
            "img_src": "http://mars.nasa.gov/mer/gallery/all/2/n/1000/2N215136972EDNAS00P1585L0M1-BR.JPG",
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
"""

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
        imgSrc = "http://mars.nasa.gov/mer/gallery/all/2/n/1000/2N215136972EDNAS00P1585L0M1-BR.JPG",
        roverDto = RoverDto(
            id = 7,
            landingDate = "2004-01-04",
            launchDate = "2003-06-10",
            name = "Spirit",
            status = "complete"
        )
    ),
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
        imgSrc = "http://mars.nasa.gov/mer/gallery/all/2/n/1000/2N215136972EDNAS00P1585L0M1-BR.JPG",
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
const val opportunityRoverHttpResponse = """
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
            "img_src": "http://mars.nasa.gov/mer/gallery/all/1/n/1000/1N216958451EFF76ZFP1950L0M1-BR.JPG",
            "earth_date": "2006-11-17",
            "rover": {
                "id": 6,
                "name": "Opportunity",
                "landing_date": "2004-01-25",
                "launch_date": "2003-07-07",
                "status": "complete"
            }
        },
        {
            "id": 141044,
            "sol": 1000,
            "camera": {
                "id": 16,
                "name": "NAVCAM",
                "rover_id": 6,
                "full_name": "Navigation Camera"
            },
            "img_src": "http://mars.nasa.gov/mer/gallery/all/1/n/1000/1N216958451EFF76ZFP1950L0M1-BR.JPG",
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
"""

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
        imgSrc = "http://mars.nasa.gov/mer/gallery/all/1/n/1000/1N216958451EFF76ZFP1950L0M1-BR.JPG",
        roverDto = RoverDto(
            id = 6,
            landingDate = "2004-01-25",
            launchDate = "2003-07-07",
            name = "Opportunity",
            status = "complete"
        )
    ),
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
        imgSrc = "http://mars.nasa.gov/mer/gallery/all/1/n/1000/1N216958451EFF76ZFP1950L0M1-BR.JPG",
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
const val errorHttpResponse = """
   {
    "error": {
        "code": "API_KEY_MISSING",
        "message": "No api_key was supplied. Get one at https://api.nasa.gov:443"
    }
} 
"""

val errorResponse = ErrorResponseDto(
    errorCode = "API_KEY_MISSING",
    errorMessage = "No api_key was supplied. Get one at https://api.nasa.gov:443"
)
//endregion
