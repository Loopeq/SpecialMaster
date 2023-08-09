package com.example.potolki.data.database

import androidx.room.*
import com.example.potolki.data.remote.model.client.ProductCartDto
import com.example.potolki.data.remote.model.client.ProductCartWithContent
import com.example.potolki.data.remote.model.server.ProductContentDto
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductCartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductToCart(product: ProductCartDto)

    @Update
    suspend fun updateProductInCart(productCartDto: ProductCartDto)

    @Delete
    suspend fun deleteProductFromCart(product: ProductCartDto)

    @Query("DELETE FROM product_cart")
    suspend fun deleteAllFromCart()

    @Query("SELECT * FROM product_cart")
    @Transaction
    fun getProductCart(): Flow<List<ProductCartWithContent>>

    @Query("SELECT EXISTS (SELECT 1 FROM product_cart WHERE product_id = :id)")
    fun checkProductInCart(id: Int): Flow<Boolean>

    @Query("SELECT SUM(totalPrice) FROM product_cart")
    fun getTotalPrice(): Flow<Int>


}