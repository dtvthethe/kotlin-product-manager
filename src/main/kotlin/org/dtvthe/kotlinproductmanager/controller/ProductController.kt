package org.dtvthe.kotlinproductmanager.controller

import org.dtvthe.kotlinproductmanager.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/products")
class ProductController (private val productService: ProductService) {
    @GetMapping()
    fun index(): List<Int> {
        return productService.getAllProducts()
    }
}