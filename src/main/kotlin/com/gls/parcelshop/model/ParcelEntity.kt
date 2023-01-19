package com.gls.parcelshop.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Table(name = "parcel")
data class ParcelEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val parcelNumber: @NotNull String? = null,
    val deliveryDate: String? = null,
    val deliveryState: DeliveryState? = null,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    val address: AddressEntity? = null,
)