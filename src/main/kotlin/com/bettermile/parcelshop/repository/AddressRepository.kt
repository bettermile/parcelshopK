package com.bettermile.parcelshop.repository

import com.bettermile.parcelshop.model.Address
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : CoroutineCrudRepository<Address, Long>
