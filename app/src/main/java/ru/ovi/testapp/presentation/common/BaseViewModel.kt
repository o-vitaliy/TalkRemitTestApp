package ru.ovi.testapp.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ovi.testapp.R
import ru.ovi.testapp.data.api.ApiException
import ru.ovi.testapp.domain.common.ResourceProvider
import ru.ovi.testapp.domain.common.Result
import ru.ovi.testapp.domain.common.postValue
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException

@SuppressWarnings("TooGenericExceptionCaught")
abstract class BaseViewModel(val resourceProvider: ResourceProvider) : ViewModel() {

    inline fun <T : Any> launch(
        liveData: LiveData<Result<T>>,
        updateLoading: Boolean = true,
        crossinline block: suspend () -> T
    ) {
        GlobalScope.launch {
            if (updateLoading) liveData.postValue(Result.Loading)
            liveData.postValue(safeExecute(block))
        }
    }

    inline fun <T : Any> launchGlobalWork(
        liveData: LiveData<Result<T>>,
        crossinline block: suspend () -> Unit
    ) {
        GlobalScope.launch {
            try {
                withContext(Dispatchers.IO) { block() }
            } catch (ex: ApiException) {
                Timber.e(ex)
                liveData.postValue(Result.Error(checkNotNull(ex.message)))
            } catch (ex: IOException) {
                Timber.e(ex)
                liveData.postValue(Result.Error(resourceProvider.getString(R.string.error_no_internet_connection)))
            } catch (ex: UnknownHostException) {
                Timber.e(ex)
                liveData.postValue(Result.Error(resourceProvider.getString(R.string.error_no_internet_connection)))
            } catch (ex: Exception) {
                Timber.e(ex)
                liveData.postValue(Result.Error(resourceProvider.getString(R.string.error_something_wrong)))
            }
        }
    }

    suspend inline fun <T : Any> safeExecute(
        crossinline block: suspend () -> T
    ): Result<T> {
        return try {
            val r: T = withContext(Dispatchers.IO) { block() }
            Result.Success(r)
        } catch (ex: ApiException) {
            Timber.e(ex)
            Result.Error(checkNotNull(ex.message))
        } catch (ex: IOException) {
            Timber.e(ex)
            Result.Error(resourceProvider.getString(R.string.error_no_internet_connection))
        } catch (ex: UnknownHostException) {
            Timber.e(ex)
            Result.Error(resourceProvider.getString(R.string.error_no_internet_connection))
        } catch (ex: Exception) {
            Timber.e(ex)
            Result.Error(resourceProvider.getString(R.string.error_something_wrong))
        }
    }
}
