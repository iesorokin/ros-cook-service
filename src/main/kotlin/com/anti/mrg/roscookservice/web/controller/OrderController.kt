package com.anti.mrg.roscookservice.web.controller

import com.anti.mrg.roscookservice.core.service.CookService
import com.anti.mrg.roscookservice.web.converter.DtosConverter
import com.anti.mrg.roscookservice.web.dto.OrderRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("order")
class OrderController(private val cookService: CookService,
                      private val dtosConverter: DtosConverter) {
    @PostMapping("create")
    fun create(@RequestBody orderRequest: OrderRequest) =
            cookService.createOrder(
                    dtosConverter.convertToOrder(orderRequest)
            )

    @PutMapping("update")
    fun update(@RequestBody orderRequest: OrderRequest) =
            cookService.updateOrder(
                    dtosConverter.convertToOrder(orderRequest)
            )

}