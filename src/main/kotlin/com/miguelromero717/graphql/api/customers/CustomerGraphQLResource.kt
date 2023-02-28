package com.miguelromero717.graphql.api.customers

import javax.inject.Inject
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class CustomerGraphQLResource {

    @Inject
    private lateinit var customerRepository: CustomerRepository

    @Query("getAllCustomers")
    @Description("Return all the customers")
    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll().list()
    }

}