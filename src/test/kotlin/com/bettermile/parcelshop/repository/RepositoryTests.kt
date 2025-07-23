package com.bettermile.parcelshop.repository

import com.bettermile.parcelshop.model.Address
import com.bettermile.parcelshop.model.DeliveryState
import com.bettermile.parcelshop.model.Parcel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class RepositoryTests @Autowired constructor(private val parcelRepository: ParcelRepository) {
    @BeforeEach
    fun cleanup() {
        parcelRepository.deleteAll()
    }

    @Test
    fun testCreateParcel() {
        parcelRepository.save(
            Parcel(
                address = createDefaultAddress(),
                parcelNumber = "1000",
                deliveryDate = "20200421",
                deliveryState = DeliveryState.OUT_FOR_DELIVERY
            )
        )
        val parcels = parcelRepository.findAll()
        Assertions.assertEquals(1, parcels.size)
    }

    private fun createDefaultAddress() = Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785")
}
