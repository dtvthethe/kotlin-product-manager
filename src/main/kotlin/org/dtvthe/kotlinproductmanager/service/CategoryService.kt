package org.dtvthe.kotlinproductmanager.service

import org.dtvthe.kotlinproductmanager.dto.CategoryDTO
import org.dtvthe.kotlinproductmanager.entity.Category
import org.dtvthe.kotlinproductmanager.entity.Product
import org.dtvthe.kotlinproductmanager.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService (private val categoryRepository: CategoryRepository) {
    fun findAll(): List<Category> = categoryRepository.findAll()

    fun create(categoryDTO: CategoryDTO) {
//        val category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
//        val result = categoryRepository.save(category);

//        println(result)
    }
}