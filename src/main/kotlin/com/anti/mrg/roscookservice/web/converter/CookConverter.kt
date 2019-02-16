package com.anti.mrg.roscookservice.web.converter

import com.anti.mrg.roscookservice.core.domain.Category
import com.anti.mrg.roscookservice.core.domain.OrderItem
import com.anti.mrg.roscookservice.web.dto.OrderItemRequest
import org.springframework.stereotype.Component

@Component
class CookConverter {
    fun convertToOrderItem(orderItemRequests: Collection<OrderItemRequest>) =
            orderItemRequests.map {
                OrderItem(
                        name = it.name,
                        category = Category.valueOf(it.category)
                )
            }
}