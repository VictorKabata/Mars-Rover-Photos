package com.vickbt.network.di

import android.util.Log
import com.vickbt.network.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.addDefaultResponseValidation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {

    single {
        HttpClient(engineFactory = CIO) {
            expectSuccess = true
            addDefaultResponseValidation()

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "api.nasa.gov"
                }
            }

            install(Logging) {
                level = LogLevel.HEADERS
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.e("Http Client", message)
                    }
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
        }
    }

    singleOf(::ApiService)

}