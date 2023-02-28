package com.miguelromero717.graphql.api.products

import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import javax.inject.Inject

@GraphQLApi
class ProductGraphQLResource {

    @Inject
    private lateinit var productRepository: ProductRepository

    @Query("getAllProducts")
    @Description("Return all the products")
    fun getAllProducts(): List<Product> {
        return productRepository.findAll().list()
    }
}