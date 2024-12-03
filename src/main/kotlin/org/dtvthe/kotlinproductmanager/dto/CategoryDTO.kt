package org.dtvthe.kotlinproductmanager.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CategoryDTO(
    val id: Long? = null,

    @field:NotNull(message = "name is required")
    @field:NotBlank(message = "name is required")
    @field:Size(min = 3, max = 120, message = "name must be between 3 and 120")
    val name: String?
)
