package org.dtvthe.kotlinproductmanager.entity

import jakarta.persistence.*

@Entity()
@Table(name = "category")
data class Category(
    @Id() @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var products: MutableSet<Product> = mutableSetOf(),
)
