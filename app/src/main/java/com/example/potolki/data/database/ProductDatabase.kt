package com.example.potolki.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.potolki.data.remote.model.client.Order
import com.example.potolki.data.remote.model.client.OrdersItemDto
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.server.ProductContentDto
import com.example.potolki.data.remote.model.server.ProductViewDto
import com.example.potolki.data.remote.model.server.ProductsReviewDto


@Database(
    entities = [ProductsReviewDto::class, ProductViewDto::class, ProductContentDto::class,
               ProductCartDto::class, OrdersItemDto::class, Order::class],
    version = 3
)
abstract class ProductDatabase: RoomDatabase() {

    abstract val productDao: ProductDao
    abstract val productCartDao: ProductCartDao
    abstract val productOrderDao: ProductOrderDao

    companion object{
        const val DATABASE_NAME = "products_v15"
    }

}