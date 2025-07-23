package com.bettermile.parcelshop.repository

import com.bettermile.parcelshop.model.Parcel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ParcelRepository : CrudRepository<Parcel, Long> {
    override fun findAll(): List<Parcel>
    fun findAllByParcelNumber(parcelNumber: String): List<Parcel>
}
