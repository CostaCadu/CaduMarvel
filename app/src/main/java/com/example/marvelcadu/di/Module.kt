package com.example.marvelcadu.di

import com.example.marvelcadu.data.remote.ServiceApi
import com.example.marvelcadu.util.Constants
import com.example.marvelcadu.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import timber.log.Timber
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object Module {
//
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(): OkHttpClient {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//
//        return OkHttpClient().newBuilder()
//            .addInterceptor { chain ->
//                val currencyTimesTamp = System.currentTimeMillis()
//                val newUrl = chain.request().url
//                    .newBuilder()
//                    .addQueryParameter(Constants.TS, currencyTimesTamp.toString())
//                    .addQueryParameter(Constants.APIKEY, Constants.PUBLIC_KEY)
//                    .addQueryParameter(
//                        Constants.HASH,
//                        provideToMd5Hash(currencyTimesTamp.toString() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY)
//                    )
//                    .build()
//
//                val newRequest = chain.request()
//                    .newBuilder()
//                    .url(newUrl)
//                    .build()
//                chain.proceed(newRequest)
//            }
//            .addInterceptor(logging)
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(client: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideServiceApi(retrofit: Retrofit): ServiceApi {
//        return retrofit.create(ServiceApi::class.java)
//    }
//
//    @Singleton
//    @Provides
//    fun provideToMd5Hash(encrypted: String): String {
//        var pass = encrypted
//        var encryptedString: String? = null
//        val md5: MessageDigest
//        try {
//            md5 = MessageDigest.getInstance("MD5")
//            md5.update(pass.toByteArray(), 0, pass.length)
//            pass = BigInteger(1, md5.digest()).toString(16)
//            while (pass.length < 32) {
//                pass = "0$pass"
//            }
//            encryptedString = pass
//        } catch (e1: NoSuchAlgorithmException) {
//            e1.printStackTrace()
//        }
//        Timber.d("hash -> $encryptedString")
//        return encryptedString ?: ""
//    }
//
//}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(createRequestWithParameters(chain.request()))
            }
            .addInterceptor(logging)
            .build()
    }

    private fun createRequestWithParameters(request: Request): Request {
        val currencyTimesTamp = System.currentTimeMillis()
        val newUrl = request.url
            .newBuilder()
            .addQueryParameter(Constants.TS, currencyTimesTamp.toString())
            .addQueryParameter(Constants.APIKEY, Constants.PUBLIC_KEY)
            .addQueryParameter(
                Constants.HASH,
                provideToMd5Hash(currencyTimesTamp.toString() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY)
            )
            .build()

        return request.newBuilder()
            .url(newUrl)
            .build()
    }

    // Restante do código...

    private fun provideToMd5Hash(encrypted: String): String {
        return try {
            val md5 = MessageDigest.getInstance("MD5")
            val digest = md5.digest(encrypted.toByteArray())
            BigInteger(1, digest).toString(16).padStart(32, '0')
        } catch (e: NoSuchAlgorithmException) {
            Timber.e(e, "Error creating MD5 hash")
            ""
        }
    }
}
