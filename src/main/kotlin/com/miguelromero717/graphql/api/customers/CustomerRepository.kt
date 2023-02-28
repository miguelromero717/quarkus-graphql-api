package com.miguelromero717.graphql.api.customers

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CustomerRepository : PanacheRepository<Customer> {



}