package com.gls.parcelshop.controller

import com.gls.parcelshop.model.ParcelEntity
import com.gls.parcelshop.repository.ParcelRepository
import com.gls.parcelshop.service.NotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ParcelController {
    @Autowired
    lateinit var parcelRepository: ParcelRepository

    @Autowired
    lateinit var notificationService: NotificationService

    @get:GetMapping("/parcels")
    val allParcels: List<ParcelEntity>
        get() = parcelRepository.findAll()

    @PostMapping(value = ["/parcels"], consumes = ["application/json"])
    fun insertNewParcels(@RequestBody parcel: ParcelEntity): ResponseEntity<ParcelEntity> {
        val savedParcel = parcelRepository.save(parcel)
        notificationService.notifySomeoneAboutChange(savedParcel)
        return ResponseEntity(savedParcel, HttpStatus.CREATED)
    }
}