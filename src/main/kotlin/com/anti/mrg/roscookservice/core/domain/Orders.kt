package com.anti.mrg.roscookservice.core.domain

data class Order(
        val orderId: String,
        val orderItems: Collection<OrderItem>? = null
)

data class OrderItem(
        val name: String,
        val category: Category
)

enum class Category{
    MEET,
    DRINK,
}