package com.gls.parcelshop.repository

import com.gls.parcelshop.model.Address
import com.gls.parcelshop.repository.ParcelRepository.findAll
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired
import com.gls.parcelshop.repository.ParcelRepository
import org.junit.jupiter.api.BeforeEach
import com.gls.parcelshop.model.Parcel
import com.gls.parcelshop.model.DeliveryState
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class RepositoryTests {
    @Autowired
    private val parcelRepository: ParcelRepository? = null
    @BeforeEach
    fun cleanup() {
        parcelRepository.deleteAll()
    }

    @Test
    fun testCreateParcel() {
        parcelRepository!!.save(
            ParcelEntity(
                address = createDefaultAddress(),
                parcelNumber = "1000",
                deliveryDate = "20200421",
                deliveryState = DeliveryState.OUT_FOR_DELIVERY,
            )
        )
        val parcels = parcelRepository.findAll()
        Assertions.assertEquals(1, parcels.size)
    }

    private fun createDefaultAddress(): AddressEntity {
        return AddressEntity(
            consignee = "GLS",
            street = "Kemperplatz",
            number = "1",
            zip = "10785",
            )
    }
}