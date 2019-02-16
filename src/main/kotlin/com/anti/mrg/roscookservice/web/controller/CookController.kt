package com.anti.mrg.roscookservice.web.controller

import com.anti.mrg.roscookservice.core.service.CookService
import com.anti.mrg.roscookservice.web.converter.CookConverter
import com.anti.mrg.roscookservice.web.dto.OrderItemRequest
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("cook")
@RestController
class CookController(private val cookService: CookService,
                     private val cookConverter: CookConverter) {
    @PutMapping("finish")
    fun finishItem(@RequestBody orderItemRequests: Collection<OrderItemRequest>) =
            cookService.finishOrderItems(
                    cookConverter.convertToOrderItem(
                            orderItemRequests
                    )
            )

}