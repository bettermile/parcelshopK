package com.bettermile.parcelshop.controller

import com.bettermile.parcelshop.model.Parcel
import com.bettermile.parcelshop.repository.ParcelRepository
import com.bettermile.parcelshop.service.NotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ParcelController(
    private val notificationService: NotificationService,
) {

    @Autowired
    private val parcelRepository: ParcelRepository? = null

    @GetMapping("/parcels")
    @ResponseStatus(HttpStatus.OK)
    fun getAllParcels(): List<Parcel> {
        return parcelRepository!!.findAll()
    }

    @PostMapping(value = ["/parcels"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.CREATED)
    fun insertNewParcels(@RequestBody parcel: Parcel): ResponseEntity<Parcel> {
        val savedParcel = parcelRepository!!.save(parcel)
        notificationService.notifySomeoneAboutChange(savedParcel)
        return ResponseEntity(savedParcel, HttpStatus.CREATED)
    }
}
