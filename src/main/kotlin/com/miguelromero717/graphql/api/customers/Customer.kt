package com.miguelromero717.graphql.api.customers

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
class Customer  {
    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var name: String
    lateinit var email: String
    lateinit var country: String
    var createdAt: Instant? = Instant.now()
}