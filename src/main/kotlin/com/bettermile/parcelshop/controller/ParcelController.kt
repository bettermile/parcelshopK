package com.bettermile.parcelshop.controller

import com.bettermile.parcelshop.model.Parcel
import com.bettermile.parcelshop.repository.AddressRepository
import com.bettermile.parcelshop.repository.CheckinRepository
import com.bettermile.parcelshop.repository.ParcelRepository
import com.bettermile.parcelshop.service.NotificationService
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ParcelController(
    private val notificationService: NotificationService
) {
    @Autowired
    private val parcelRepository: ParcelRepository? = null

    @Autowired
    private val addressRepository: AddressRepository? = null

    @Autowired
    private val checkinRepository: CheckinRepository? = null

    @GetMapping("/parcels")
    @ResponseStatus(HttpStatus.OK)
    suspend fun getAllParcels(): List<Parcel> =
        parcelRepository!!.findAll()
            .map {
                it.apply {
                    this.checkins = checkinRepository!!.findAllByParcelId(it.id).toList()
                    this.address = addressRepository!!.findById(it.addressId)
                }
            }.toList()


    @PostMapping(value = ["/parcels"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun insertNewParcels(@RequestBody parcel: Parcel): Parcel {
        val savedParcel = parcelRepository!!.save(parcel)

        notificationService.notifySomeoneAboutChange(savedParcel)
        return savedParcel
    }
}
