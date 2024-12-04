package org.dtvthe.kotlinproductmanager.controller

import jakarta.validation.Valid
import org.dtvthe.kotlinproductmanager.dto.CategoryDTO
import org.dtvthe.kotlinproductmanager.entity.Category
import org.dtvthe.kotlinproductmanager.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping("")
    fun index(): List<Category> {
        return categoryService.findAll()
    }

    @PostMapping("")
    fun create(@Valid @RequestBody categoryDTO: CategoryDTO): String {
        val category = categoryService.create(categoryDTO)

        return "Create category: $category"
    }
}
