package com.bettermile.parcelshop.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("checkins")
class Checkin(
    @Id
    var id: Long = 0,
    @Column("location_name")
    var locationName: String,
    @Column("checkin_date")
    var checkinDate: String,
    @Column("parcel_id")
    var parcelId: Long
)
