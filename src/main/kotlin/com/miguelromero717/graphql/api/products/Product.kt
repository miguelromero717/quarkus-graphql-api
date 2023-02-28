package com.miguelromero717.graphql.api.products

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
class Product {
    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var name: String
    var description: String? = null
    var price: Double? = 0.0
    @Column(name = "created_at")
    var createdAt: Instant? = Instant.now()
}