package com.bettermile.parcelshop.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("checkins")
class Checkin(
    @Id
    var id: Long = 0,
    var locationName: String,
    var checkinDate: String,
    var parcelId: Long
)
