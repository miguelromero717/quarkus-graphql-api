package com.miguelromero717.graphql.api.products

import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import javax.inject.Inject
import javax.transaction.Transactional

@GraphQLApi
class ProductGraphQLResource {

    @Inject
    private lateinit var productRepository: ProductRepository

    @Query("getAllProducts")
    @Description("Return all the products")
    fun getAllProducts(): List<Product> {
        return productRepository.findAll().list()
    }

    @Transactional
    @Mutation("addProduct")
    fun addProduct(product: Product): Product {
        productRepository.persistAndFlush(product)
        return product
    }
}