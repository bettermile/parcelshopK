package com.gls.parcelshop.model

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Table(name = "address")
data class AddressEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val street: String? = null,
    val zip: String? = null,
    val number: String? = null,
    val consignee: String? = null,

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    val parcel: ParcelEntity? = null,
)