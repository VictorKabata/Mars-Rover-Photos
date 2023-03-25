package com.vickbt.repository.utils

import com.vickbt.domain.models.ErrorResponse
import com.vickbt.domain.utils.NetworkResultState
import com.vickbt.network.models.ErrorResponseDto
import com.vickbt.repository.mappers.toDomain
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import java.nio.channels.UnresolvedAddressException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

suspend fun <T : Any?> safeApiCall(apiCall: suspend () -> T): Flow<NetworkResultState<T>> =
    channelFlow {
        send(NetworkResultState.Loading)
        try {
            send(NetworkResultState.Success(apiCall.invoke()))
        } catch (e: RedirectResponseException) {
            val error = parseNetworkError(e.response.body())
            send(NetworkResultState.Failure(exception = error))
        } catch (e: ClientRequestException) {
            val error = parseNetworkError(e.response.body())
            send(NetworkResultState.Failure(exception = error))
        } catch (e: ServerResponseException) {
            val error = parseNetworkError(e.response.body())
            send(NetworkResultState.Failure(exception = error))
        } catch (e: UnresolvedAddressException) {
            val error = parseNetworkError(exception = e)
            send(NetworkResultState.Failure(exception = error))
        } catch (e: Exception) {
            val error = parseNetworkError(exception = e)
            send(NetworkResultState.Failure(exception = error))
        }
    }

/**Generate [Exception] from network or system error when making network calls
 * @throws [Exception]*/
internal suspend fun parseNetworkError(
    errorResponse: HttpResponse? = null,
    exception: Exception? = null
): Exception {
    throw errorResponse?.body<ErrorResponseDto>()?.toDomain()
        ?: ErrorResponse(errorMessage = exception?.message ?: "Error")
}
