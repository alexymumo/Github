package com.codes.remote

import com.codes.remote.api.GithubApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubApiTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var githubApi: GithubApi
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var httpLoggingInterceptor: HttpLoggingInterceptor
    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start(8080)
        httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        githubApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)

    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }
}