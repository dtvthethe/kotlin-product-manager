package org.dtvthe.kotlinproductmanager.service

import org.springframework.stereotype.Service

@Service
class ProductService {
    fun getAllProducts(): List<Int> {
        return listOf(1, 2, 3)
    }
}