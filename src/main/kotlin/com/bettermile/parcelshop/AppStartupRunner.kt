package com.bettermile.parcelshop

import com.bettermile.parcelshop.model.Address
import com.bettermile.parcelshop.model.Checkin
import com.bettermile.parcelshop.model.DeliveryState
import com.bettermile.parcelshop.model.Parcel
import com.bettermile.parcelshop.repository.AddressRepository
import com.bettermile.parcelshop.repository.CheckinRepository
import com.bettermile.parcelshop.repository.ParcelRepository
import com.bettermile.parcelshop.util.ApplicationLogger.info
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.stereotype.Component

@Component
class AppStartupRunner(
    private val addressRepository: AddressRepository,
    private val parcelRepository: ParcelRepository,
    private val checkinRepository: CheckinRepository,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        info("Your application started with option names : ${args.optionNames}")
        runBlocking {
            val addresses = addressRepository.saveAll(
                listOf(
                    Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785"),
                    Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785"),
                    Address(consignee = "Max Mustermann", street = "Weinbergsweg", number = "2", zip = "10119"),
                    Address(consignee = "Hans Meier", street = "Weinbergsweg", number = "3", zip = "10119"),
                    Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785"),
                )
            ).toList()

            val parcels = parcelRepository.saveAll(
                listOf(
                    Parcel(
                        addressId = addresses[0].id,
                        parcelNumber = "1000",
                        deliveryDate = "20200421",
                        deliveryState = DeliveryState.OUT_FOR_DELIVERY
                    ),
                    Parcel(
                        addressId = addresses[1].id,
                        parcelNumber = "1001",
                        deliveryDate = "20200421",
                        deliveryState = DeliveryState.OUT_FOR_DELIVERY
                    ),
                    Parcel(
                        addressId = addresses[2].id,
                        parcelNumber = "1002",
                        deliveryDate = "20200421",
                        deliveryState = DeliveryState.OUT_FOR_DELIVERY
                    ),
                    Parcel(
                        addressId = addresses[3].id,
                        parcelNumber = "1003",
                        deliveryDate = "20200421",
                        deliveryState = DeliveryState.DELIVERED
                    ),
                    Parcel(
                        addressId = addresses[4].id,
                        parcelNumber = "1004",
                        deliveryDate = "20200420",
                        deliveryState = DeliveryState.READY_FOR_DELIVERY
                    )
                )
            ).toList()

            listOf(
                Checkin(
                    locationName = "Location 1",
                    checkinDate = parcels.first().deliveryDate,
                    parcelId = parcels.first().id
                ),
                Checkin(
                    locationName = "Location 2",
                    checkinDate = parcels.first().deliveryDate,
                    parcelId = parcels.first().id
                ),
                Checkin(
                    locationName = "Location 3",
                    checkinDate = parcels.first().deliveryDate,
                    parcelId = parcels.first().id
                ),
            ).run(checkinRepository::saveAll).collect { }
        }
    }
}
