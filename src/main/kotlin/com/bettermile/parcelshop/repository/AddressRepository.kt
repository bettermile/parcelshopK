package com.bettermile.parcelshop.repository

import com.bettermile.parcelshop.model.Address
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : CrudRepository<Address, Long> {
    override fun findAll(): List<Address>
}
