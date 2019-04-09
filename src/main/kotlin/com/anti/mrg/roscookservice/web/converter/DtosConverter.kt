package com.anti.mrg.roscookservice.web.converter

import com.anti.mrg.roscookservice.core.domain.Category
import com.anti.mrg.roscookservice.core.domain.Order
import com.anti.mrg.roscookservice.core.domain.OrderItem
import com.anti.mrg.roscookservice.web.dto.OrderItemRequest
import com.anti.mrg.roscookservice.web.dto.OrderRequest
import org.springframework.stereotype.Component


@Component
class DtosConverter {
    fun convertToOrderItem(orderItemRequests: Collection<OrderItemRequest>) =
            orderItemRequests.map { it.toOrderItem() }

    fun convertToOrder(orderCreateRequest: OrderRequest) =
            Order(
                    orderId = orderCreateRequest.orderId,
                    orderItems = orderCreateRequest.orderItems.map { it.toOrderItem() }
            )

    private fun OrderItemRequest.toOrderItem(): OrderItem =
            OrderItem(
                    name = name,
                    category = Category.valueOf(category)
            )

}