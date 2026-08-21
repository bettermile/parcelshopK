package com.bettermile.parcelshop.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("parcel")
class Parcel(
    @Id
    var id: Long = 0,
    @Column("parcel_number")
    var parcelNumber: String,
    @Column("delivery_date")
    var deliveryDate: String,
    @Column("delivery_state")
    var deliveryState: DeliveryState,
    @Column("address_id")
    var addressId: Long = 0,
) {
    @Transient
    var address: Address? = null

    @Transient
    var checkins: List<Checkin> = listOf()
}
