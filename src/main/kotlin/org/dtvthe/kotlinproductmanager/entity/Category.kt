package org.dtvthe.kotlinproductmanager.entity

import jakarta.persistence.*

@Entity()
@Table(name = "category")
data class Category(
    @Id() @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "name", nullable = false)
    val name: String,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val products: MutableSet<Product>
)
