package com.anti.mrg.roscookservice.core.repository

import com.anti.mrg.roscookservice.core.domain.Order
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface CookRepository : MongoRepository<Order, String> {
    override fun findById(id: String): Optional<Order>
}