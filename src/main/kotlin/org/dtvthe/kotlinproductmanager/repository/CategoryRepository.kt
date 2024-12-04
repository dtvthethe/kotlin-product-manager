package org.dtvthe.kotlinproductmanager.repository

import org.dtvthe.kotlinproductmanager.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {
}