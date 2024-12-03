package org.dtvthe.kotlinproductmanager.entity

import jakarta.persistence.*

@Entity()
@Table(name = "product")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "price", nullable = false)
    val price: Double,

    @Column(name = "quantity", nullable = false)
    val quantity: Int,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "product_tags",
        joinColumns = [JoinColumn(name = "product_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")]
    )
    val tags: MutableSet<Tag>
)
