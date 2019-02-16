package com.anti.mrg.roscookservice.web.dto

data class OrderRequest(
        val orderId: String,
        val orderItems: Collection<OrderItemRequest>
)

data class OrderItemRequest(
        val name: String,
        val category: String
)