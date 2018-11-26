package com.nomtek.avonil.data.repository

import android.util.Log
import retrofit2.Response
import rx.Observable
import javax.security.auth.login.LoginException

/**
 * Created by avonil on 19.07.17.
 */
open class BaseRepository {

    fun <T> parseResponse(it: Response<T>): Observable<T>? {
        return if (it.isSuccessful) {
            Observable.just(it.body())
        } else {
            Observable.error(LoginException())
        }

    }
}
