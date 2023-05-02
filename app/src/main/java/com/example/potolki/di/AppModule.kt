package com.example.potolki.di

import com.example.potolki.data.repository.MaterialRepositoryImpl
import com.example.potolki.domain.repository.MaterialRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMaterialRepository(): MaterialRepository{
        return MaterialRepositoryImpl()
    }

}