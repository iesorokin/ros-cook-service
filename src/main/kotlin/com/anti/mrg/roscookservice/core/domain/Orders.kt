package com.anti.mrg.roscookservice.core.domain

data class Order(
        val orderId: String,
        val orderItems: Collection<OrderItem>? = null
        //todo: create new items
)

data class OrderItem(
        //todo: create id
        val name: String,
        val category: Category
)

enum class Category{
    MEET,
    DRINK,
}