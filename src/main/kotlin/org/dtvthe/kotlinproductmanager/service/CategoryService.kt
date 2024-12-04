package org.dtvthe.kotlinproductmanager.service

import org.dtvthe.kotlinproductmanager.dto.CategoryDTO
import org.dtvthe.kotlinproductmanager.entity.Category
import org.dtvthe.kotlinproductmanager.repository.CategoryRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository, private val modelMapper: ModelMapper) {
    fun findAll(): List<Category> = categoryRepository.findAll()

    fun create(categoryDTO: CategoryDTO) {
        println(categoryDTO.toString())
        val category = convertCategoryDTOToEntity(categoryDTO)
        println(category.toString())

//        val category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
//        val result = categoryRepository.save(category);

//        println(result)
    }

    fun convertCategoryDTOToEntity(categoryDTO: CategoryDTO): Category {
        return modelMapper.map(categoryDTO, Category::class.java)
    }
}