package com.anti.mrg.roscookservice.web.converter

import com.anti.mrg.roscookservice.core.domain.Category
import com.anti.mrg.roscookservice.core.domain.Order
import com.anti.mrg.roscookservice.core.domain.OrderItem
import com.anti.mrg.roscookservice.web.dto.OrderRequest
import org.springframework.stereotype.Component

@Component
class OrderConverter {
    fun convertToOrder(orderCreateRequest: OrderRequest) =
            Order(
                    orderId = orderCreateRequest.orderId,
                    orderItems = orderCreateRequest.orderItems.map {
                        OrderItem(
                                name = it.name,
                                category = Category.valueOf(it.category)
                        )
                    }
            )
}