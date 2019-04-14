package com.anti.mrg.roscookservice.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "orders")
data class Order(
        @Id
        val orderId: String,
        val orderItems: Collection<OrderItem>
)

data class OrderItem(
        val itemId: String,
        val name: String,
        val category: Category
)

enum class Category {
    COLD_PLATTER,
    HOT_APPETIZER,
    STARTER,
    SOUP,
    SALAD,
    MAIN_DISH,
    MEAT,
    POULTRY_DISH,
    FISH,
    SIDE_DISH,
    SNACK,
    DESSERT,
    BEVERAGES,
    SOFT_DRINK,
    HOT_DRINK,
    WINE,
}