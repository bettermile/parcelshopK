package com.bettermile.parcelshop.repository

import com.bettermile.parcelshop.model.Parcel
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ParcelRepository : CoroutineCrudRepository<Parcel, Long> {
    suspend fun findAllByParcelNumber(parcelNumber: String): Flow<Parcel>
}
