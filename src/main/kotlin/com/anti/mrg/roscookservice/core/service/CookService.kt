package com.anti.mrg.roscookservice.core.service

import com.anti.mrg.roscookservice.core.domain.Order
import com.anti.mrg.roscookservice.core.domain.OrderItem
import com.anti.mrg.roscookservice.core.repository.CookRepository
import com.anti.mrg.roscookservice.exceptions.NotFoundOrderException
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}

@Service
class CookService(
        private val cookRepository: CookRepository
) {
    fun createOrder(order: Order) {
        log.info { "Create new order: $order" }
        cookRepository.save(order)
        log.info { "Order with orderId: ${order.orderId} was created" }
    }

    fun updateOrder(order: Order) {
        log.info { "Update order: $order" }
        val existOrder = cookRepository.findById(order.orderId).orElseThrow { NotFoundOrderException() }
        val updatedOrder = mergeOrder(order, existOrder)
        cookRepository.save(updatedOrder)
        log.info { "Order with orderId: ${updatedOrder.orderId} was updated" }
    }

    private fun mergeOrder(order: Order, existOrder: Order): Order =
            Order(
                    orderId = existOrder.orderId,
                    orderItems = existOrder.orderItems.toMutableList().also { it.addAll(order.orderItems) }
            )

    fun finishOrderItems(orderId: String, orderItems: Collection<OrderItem>) {
        log.info { "Finish order items: $orderItems" }
        val order = cookRepository.findById(orderId).orElseThrow { NotFoundOrderException() }
        val updatedOrder = Order(
                orderId = orderId,
                orderItems = order.orderItems.filter { orderItems.notContains(it) }
        )
        cookRepository.save(updatedOrder)
        log.info { "Order items was finished" }
    }

    fun getAllOrdersOnKitchen(): Collection<Order> {
        log.info { "Get all orders" }
        return cookRepository.findAll()
    }
}

private fun <E> Collection<E>.notContains(element: E): Boolean {
    return !this.contains(element)
}
