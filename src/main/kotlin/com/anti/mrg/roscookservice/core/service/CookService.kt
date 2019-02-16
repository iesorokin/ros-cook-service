package com.anti.mrg.roscookservice.core.service

import com.anti.mrg.roscookservice.core.domain.Order
import com.anti.mrg.roscookservice.core.domain.OrderItem
import org.springframework.stereotype.Service

@Service
class CookService {
    fun createOrder(order: Order) {
        //todo: add mongo at project
    }

    fun updateOrder(convertToOrder: Order) {
    }

    fun finishOrderItems(orderItems: Collection<OrderItem>) {
    }
}