package org.dtvthe.kotlinproductmanager.service

import org.dtvthe.kotlinproductmanager.dto.CategoryDTO
import org.dtvthe.kotlinproductmanager.entity.Category
import org.dtvthe.kotlinproductmanager.repository.CategoryRepository
import org.modelmapper.ModelMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository, private val modelMapper: ModelMapper) {
    val logger = LoggerFactory.getLogger(CategoryService::class.java)

    fun findAll(): List<Category> = categoryRepository.findAll()

    fun create(categoryDTO: CategoryDTO): Category {
        val category = convertCategoryDTOToEntity(categoryDTO)
        val result = categoryRepository.save(category)
        logger.info("Create category: $result")

        return result
    }

    fun convertCategoryDTOToEntity(categoryDTO: CategoryDTO): Category {
        return modelMapper.map(categoryDTO, Category::class.java)
    }
}
