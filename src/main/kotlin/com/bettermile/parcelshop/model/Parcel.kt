package com.bettermile.parcelshop.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Table

@Table("parcel")
class Parcel(
    @Id
    var id: Long = 0,
    var parcelNumber: String,
    var deliveryDate: String,
    var deliveryState: DeliveryState,
    var addressId: Long = 0,
) {
    @Transient
    var address: Address? = null

    @Transient
    var checkins: List<Checkin> = listOf()
}
