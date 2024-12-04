package org.dtvthe.kotlinproductmanager.entity

import jakarta.persistence.*

@Entity
@Table(name = "tag")
data class Tag(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "name", nullable = false)
    val name: String,

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    val products: MutableSet<Product>
)
