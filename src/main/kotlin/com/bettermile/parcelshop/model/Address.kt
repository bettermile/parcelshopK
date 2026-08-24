package com.bettermile.parcelshop.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("address")
class Address(
    @Id
    var id: Long = 0,
    var street: String,
    var zip: String,
    var number: String,
    var consignee: String,
    val parcelId: Long? = null,
)
