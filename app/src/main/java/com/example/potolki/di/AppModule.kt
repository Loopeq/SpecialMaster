package com.example.potolki.di

import android.app.Application
import androidx.room.Room
import com.example.potolki.data.database.ProductDao
import com.example.potolki.data.database.ProductDatabase
import com.example.potolki.data.repository.MaterialRepositoryImpl
import com.example.potolki.data.repository.ProductCartRepositoryImpl
import com.example.potolki.data.repository.ProductOrderRepositoryImpl
import com.example.potolki.data.repository.ProductViewRepositoryImpl
import com.example.potolki.domain.repository.MaterialRepository
import com.example.potolki.domain.repository.ProductCartRepository
import com.example.potolki.domain.repository.ProductOrderRepository
import com.example.potolki.domain.repository.ProductViewRepository
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
    fun provideProductDatabase(app: Application): ProductDatabase{
        return Room.databaseBuilder(
            app,
            ProductDatabase::class.java,
            ProductDatabase.DATABASE_NAME
        ).createFromAsset("databases/${ProductDatabase.DATABASE_NAME}.db").build()
    }


    @Provides
    @Singleton
    fun provideMaterialRepository(database: ProductDatabase): MaterialRepository{
        return MaterialRepositoryImpl(database.productDao)
    }

    @Provides
    @Singleton
    fun provideProductCartRepository(database: ProductDatabase): ProductCartRepository{
        return ProductCartRepositoryImpl(database.productCartDao)
    }

    @Provides
    @Singleton
    fun provideProductViewRepository(database: ProductDatabase): ProductViewRepository{
        return ProductViewRepositoryImpl(database.productDao)
    }

    @Provides
    @Singleton
    fun provideProductOrderRepository(database: ProductDatabase): ProductOrderRepository{
        return ProductOrderRepositoryImpl(database.productOrderDao)
    }

}