package com.bettermile.parcelshop.repository

import com.bettermile.parcelshop.model.Checkin
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckinRepository : CoroutineCrudRepository<Checkin, Long> {

    suspend fun findAllByParcelId(parcelId: Long): Flow<Checkin>
}
