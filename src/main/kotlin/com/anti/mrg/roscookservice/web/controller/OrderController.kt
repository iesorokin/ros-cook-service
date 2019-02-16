package com.anti.mrg.roscookservice.web.controller

import com.anti.mrg.roscookservice.core.service.CookService
import com.anti.mrg.roscookservice.web.converter.OrderConverter
import com.anti.mrg.roscookservice.web.dto.OrderRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("order")
class OrderController(
        private val orderService: CookService,
        private val orderConverter: OrderConverter
) {
    @PostMapping("create")
    fun create(@RequestBody orderRequest: OrderRequest) =
            orderService.createOrder(
                    orderConverter.convertToOrder(orderRequest)
            )

    @PutMapping("update")
    fun update(@RequestBody orderRequest: OrderRequest) =
            orderService.updateOrder(
                    orderConverter.convertToOrder(orderRequest)
            )
}