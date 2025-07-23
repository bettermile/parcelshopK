package com.bettermile.parcelshop.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "address")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var street: String,
    var zip: String,
    var number: String,
    var consignee: String,

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private val parcel: Parcel? = null
)
