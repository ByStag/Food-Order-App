package com.ahmetkaya.yemeksiparisiapi.di

import com.ahmetkaya.yemeksiparisiapi.data.datasource.YemeklerDataSource
import com.ahmetkaya.yemeksiparisiapi.data.repo.YemeklerRepository
import com.ahmetkaya.yemeksiparisiapi.retrofit.ApiUtils
import com.ahmetkaya.yemeksiparisiapi.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDataSource(ydao: YemeklerDao) : YemeklerDataSource{
        return YemeklerDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideYemeklerRepository(yds : YemeklerDataSource) : YemeklerRepository {
        return YemeklerRepository(yds)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao {
        return ApiUtils.getYemeklerDao()
    }
}