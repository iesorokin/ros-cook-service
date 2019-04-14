package com.anti.mrg.roscookservice.web.controller

import com.anti.mrg.roscookservice.core.service.CookService
import com.anti.mrg.roscookservice.web.converter.DtosConverter
import com.anti.mrg.roscookservice.web.dto.OrderItemRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("cook")
@RestController
class CookController(private val cookService: CookService,
                     private val dtosConverter: DtosConverter) {
    @PutMapping("finish")
    fun finishItems(@PathVariable orderId: String,
                    @RequestBody orderItemRequests: Collection<OrderItemRequest>) =
            cookService.finishOrderItems(
                    orderId,
                    dtosConverter.convertToOrderItem(
                            orderItemRequests
                    )
            )

    @GetMapping("getAll")
    fun getAllOrders() {
        cookService.getAllOrdersOnKitchen()
        //todo: add convert to external object
    }

}