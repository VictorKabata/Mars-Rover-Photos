package com.vickbt.repository.mappers

import com.vickbt.domain.models.Camera
import com.vickbt.domain.models.Error
import com.vickbt.domain.models.ErrorResponse
import com.vickbt.domain.models.Photo
import com.vickbt.domain.models.Rover
import com.vickbt.network.models.CameraDto
import com.vickbt.network.models.ErrorDto
import com.vickbt.network.models.ErrorResponseDto
import com.vickbt.network.models.PhotoDto
import com.vickbt.network.models.RoverDto

internal fun CameraDto.toDomain(): Camera {
    return Camera(
        fullName = this.fullName,
        id = this.id,
        name = this.name,
        roverId = this.roverId
    )
}

internal fun PhotoDto.toDomain(): Photo {
    return Photo(
        camera = this.cameraDto.toDomain(),
        earthDate = this.earthDate,
        id = this.id,
        imgSrc = this.imgSrc,
        rover = this.roverDto.toDomain(),
        sol = this.sol
    )
}

internal fun RoverDto.toDomain(): Rover {
    return Rover(
        id = this.id,
        landingDate = this.landingDate,
        launchDate = this.launchDate,
        name = this.name,
        status = this.status
    )
}

internal fun ErrorDto.toDomain(): Error {
    return Error(
        errorCode = errorCode,
        errorMessage = errorMessage
    )
}

internal fun ErrorResponseDto.toDomain(): ErrorResponse {
    return ErrorResponse(error = this.error.toDomain())
}
