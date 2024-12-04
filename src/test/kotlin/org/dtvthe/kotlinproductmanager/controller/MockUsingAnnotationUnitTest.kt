package org.dtvthe.kotlinproductmanager.controller

import org.dtvthe.kotlinproductmanager.dto.CategoryDTO
import org.dtvthe.kotlinproductmanager.entity.Category
import org.dtvthe.kotlinproductmanager.repository.CategoryRepository
import org.dtvthe.kotlinproductmanager.service.CategoryService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import org.modelmapper.ModelMapper
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class MockUsingAnnotationUnitTest {
    @Mock
    private lateinit var categoryRepository: CategoryRepository

    @Spy
    private lateinit var modelMapper: ModelMapper

    @InjectMocks
    private lateinit var categoryService: CategoryService

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

