package com.anti.mrg.roscookservice.core.service

import com.anti.mrg.roscookservice.core.domain.Order
import com.anti.mrg.roscookservice.core.domain.OrderItem
import com.anti.mrg.roscookservice.core.repository.CookRepository
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
        cookRepository.save(order)
        log.info { "Order with orderId: ${order.orderId} was updated" }
    }

    fun finishOrderItems(orderItems: Collection<OrderItem>) {
        log.info { "Finish order items: $orderItems" }
        val orders = cookRepository.findAll().map { it.orderId to it }.toMap()
        orderItems.forEach {
            val order = orders[it.name]//todo: replace with id
            //todo: add finish order item
        }
        log.info { "Order items was finished" }
    }

    fun getAllOrdersOnKitchen(): Collection<Order> {
        log.info { "Get all orders" }
        return cookRepository.findAll()
    }
}