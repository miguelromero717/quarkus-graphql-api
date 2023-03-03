package com.miguelromero717.graphql.api.customers

import javax.inject.Inject
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import javax.transaction.Transactional

@GraphQLApi
class CustomerGraphQLResource {

    @Inject
    private lateinit var customerRepository: CustomerRepository

    @Query("getAllCustomers")
    @Description("Return all the customers")
    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll().list()
    }

    @Query("getCustomerById")
    fun getCustomerById(id: Long): Customer? {
        return customerRepository.findById(id)
    }

    @Query("getCustomerByName")
    fun getCustomerByName(name: String): Customer? {
        return customerRepository.find("name = ?1", name).firstResult()
    }

    @Query("getCustomerByEmail")
    fun getCustomerByEmail(email: String): Customer? {
        return customerRepository.find("email = ?1", email).firstResult()
    }

    @Transactional
    @Mutation("addCustomer")
    fun addCustomer(customer: Customer): Customer {
        customerRepository.persistAndFlush(customer)
        return customer
    }

}