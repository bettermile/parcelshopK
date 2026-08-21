package com.bettermile.parcelshop.repository

import com.bettermile.parcelshop.model.Address
import com.bettermile.parcelshop.model.DeliveryState
import com.bettermile.parcelshop.model.Parcel
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class ParcelRepositoryTest(
    @Autowired private val parcelRepository: ParcelRepository,
    @Autowired private val addressRepository: AddressRepository,
    @Autowired private val checkinRepository: CheckinRepository,
) {
    @BeforeEach
    fun cleanup() = runBlocking {
        checkinRepository.deleteAll()
        parcelRepository.deleteAll()
        addressRepository.deleteAll()
    }

    @Test
    fun testCreateParcel() = runBlocking {
        parcelRepository.save(
            Parcel(
                addressId = createDefaultAddress().id,
                parcelNumber = "1000",
                deliveryDate = "20200421",
                deliveryState = DeliveryState.OUT_FOR_DELIVERY
            )
        )
        val parcels = parcelRepository.findAll().toList()
        Assertions.assertEquals(1, parcels.size)
    }

    @Test
    fun testFindAllByParcelNumber() = runBlocking {
        parcelRepository.save(
            Parcel(
                addressId = createDefaultAddress().id,
                parcelNumber = "1000",
                deliveryDate = "20250421",
                deliveryState = DeliveryState.OUT_FOR_DELIVERY
            )
        )
        parcelRepository.save(
            Parcel(
                addressId = createDefaultAddress().id,
                parcelNumber = "2000",
                deliveryDate = "20250421",
                deliveryState = DeliveryState.OUT_FOR_DELIVERY
            )
        )
        val parcels = parcelRepository.findAllByParcelNumber("2000").toList()
        Assertions.assertEquals(1, parcels.size)
    }

    private suspend fun createDefaultAddress() =
        addressRepository.save(Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785"))
}
