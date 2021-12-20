package com.example.omdbmovie.di.modules

import com.example.omdbmovie.api.MovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        private const val BASE_URL = "https://www.omdbapi.com"
        const val API_KEY = "557794d"
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideRetrofitClient(
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        //.client(client)
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideMovieService(
        retrofit: Retrofit
    ): MovieService = retrofit.create(MovieService::class.java)

//    @Provides
//    @Singleton
//    fun proviesLoggingInterceptor(): HttpLoggingInterceptor {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        return httpLoggingInterceptor
//    }
//
//    @Provides
//    @Singleton
//    fun providesClient(): OkHttpClient{
//        return OkHttpClient.Builder()
//            .addInterceptor(getLoggingInterceptor())
//            .build()
//    }
}