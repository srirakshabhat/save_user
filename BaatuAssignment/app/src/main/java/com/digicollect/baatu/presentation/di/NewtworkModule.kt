package com.digicollect.baatu.presentation.di


import com.digicollect.baatu.data.api.UserApiService
import com.digicollect.baatu.utility.UserConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.GsonBuilder

import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NewtworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        val gson = GsonBuilder().setLenient().create()

        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
            this.connectTimeout(60, TimeUnit.SECONDS)
        }.build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(UserConstant.BASE_DOMAIN)
            .client(client)
            .build()
    }

    @Provides
    fun providesUserApiService(retrofit: Retrofit):UserApiService {
        return retrofit.create(UserApiService::class.java)
    }


}