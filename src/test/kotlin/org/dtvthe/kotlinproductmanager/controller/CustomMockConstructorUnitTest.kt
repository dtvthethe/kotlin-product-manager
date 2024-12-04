package org.dtvthe.kotlinproductmanager.controller

import org.dtvthe.kotlinproductmanager.dto.CategoryDTO
import org.dtvthe.kotlinproductmanager.entity.Category
import org.dtvthe.kotlinproductmanager.repository.CategoryRepository
import org.dtvthe.kotlinproductmanager.service.CategoryService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.modelmapper.ModelMapper
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // --> Không dùng static nếu là Kotlin
class CustomMockConstructorUnitTest {
    private val categoryRepository: CategoryRepository = mock() // mock all

    private val modelMapper = ModelMapper() // không mock

    private lateinit var categoryService: CategoryService

    @BeforeAll
    fun setupGlobal() {
        categoryService = CategoryService(categoryRepository, modelMapper)
    }

    @Test
    fun mockCategoryServiceTest() {
        val categoryDTO = CategoryDTO(
            name = "test",
        )
        val categoryInput = Category(
            id = null,
            name = "test",
            products = mutableSetOf()
        )
        val categoryEntity = Category(
            id = 1,
            name = "test",
            products = mutableSetOf()
        )
        whenever(categoryRepository.save(categoryInput)).thenReturn(categoryEntity)
        val result = categoryService.create(categoryDTO)
        assertEquals(result, categoryEntity)
    }
}
