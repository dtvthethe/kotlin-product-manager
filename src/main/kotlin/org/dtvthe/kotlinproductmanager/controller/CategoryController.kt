package org.dtvthe.kotlinproductmanager.controller

import jakarta.validation.Valid
import org.dtvthe.kotlinproductmanager.dto.CategoryDTO
import org.dtvthe.kotlinproductmanager.entity.Category
import org.dtvthe.kotlinproductmanager.service.CategoryService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(private val categoryService: CategoryService) {
    val logger = LoggerFactory.getLogger(CategoryController::class.java)

    @GetMapping("")
    fun index(): List<Category> {
        return categoryService.findAll()
    }

    @PostMapping("")
    fun create(@Valid @RequestBody categoryDTO: CategoryDTO): String {
        logger.info("This is an INFO log")
        logger.warn("This is a WARN log")
        logger.error("This is an ERROR log")

        categoryService.create(categoryDTO)
        return "aaa"
    }
}
