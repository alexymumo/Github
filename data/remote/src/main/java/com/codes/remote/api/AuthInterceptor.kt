package com.codes.remote.api

import com.codes.common.Constants.GITHUB_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $GITHUB_TOKEN")
            .build()
        return chain.proceed(request)
    }
}