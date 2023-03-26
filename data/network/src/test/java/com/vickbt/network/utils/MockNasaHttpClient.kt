package com.vickbt.network.utils

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.addDefaultResponseValidation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class MockNasaHttpClient {

    private var httpStatusCode: HttpStatusCode? = null
    private var responseContent: String? = null
    fun throwError(
        httpStatus: HttpStatusCode = HttpStatusCode.InternalServerError,
        response: String = errorHttpResponse
    ) {
        httpStatusCode = httpStatus
        responseContent = response
    }

    private val responseHeaders = headersOf(HttpHeaders.ContentType, "application/json")

    val mockHttpClient = HttpClient(MockEngine) {
        engine {
            addHandler { request ->
                when (request.url.fullPath) {
                    "/mars-photos/api/v1/rovers/curiosity/photos?page=1&sol=1000" -> {
                        respond(
                            responseContent ?: curiosityRoverHttpResponse,
                            httpStatusCode ?: HttpStatusCode.OK,
                            responseHeaders
                        )
                    }
                    "/mars-photos/api/v1/rovers/spirit/photos?page=1&sol=1000" -> {
                        respond(
                            responseContent ?: spiritRoverHttpResponse,
                            httpStatusCode ?: HttpStatusCode.OK,
                            responseHeaders
                        )
                    }
                    "/mars-photos/api/v1/rovers/opportunity/photos?page=1&sol=1000" -> {
                        respond(
                            responseContent ?: opportunityRoverHttpResponse,
                            httpStatusCode ?: HttpStatusCode.OK,
                            responseHeaders
                        )
                    }
                    else -> {
                        respond(
                            responseContent ?: errorHttpResponse,
                            httpStatusCode ?: HttpStatusCode.InternalServerError,
                            responseHeaders
                        )
                    }
                }
            }
        }

        expectSuccess = true
        addDefaultResponseValidation()

        defaultRequest { contentType(ContentType.Application.Json) }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println("Http Logs: $message")
                }
            }
        }
    }
}
