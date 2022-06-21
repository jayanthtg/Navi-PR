package com.github.core.cloud

import com.github.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


internal class GitRemote private constructor() {

    private val retrofit: Retrofit

    init {
        retrofit = getDefaultClient()
    }

    fun client() = retrofit

    private fun getDefaultClient(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.Url.BASE_URL)
            .build()
    }

    companion object {
        private val x = GitRemote()

        @JvmStatic
        fun get(): GitRemote {
            return x
        }
    }

}