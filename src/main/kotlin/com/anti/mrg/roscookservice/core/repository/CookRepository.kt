package com.anti.mrg.roscookservice.core.repository

import com.anti.mrg.roscookservice.core.domain.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface CookRepository : MongoRepository<Order, String> {
}