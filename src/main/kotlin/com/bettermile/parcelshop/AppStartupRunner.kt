package com.bettermile.parcelshop

import com.bettermile.parcelshop.model.Address
import com.bettermile.parcelshop.model.DeliveryState
import com.bettermile.parcelshop.model.Parcel
import com.bettermile.parcelshop.repository.ParcelRepository
import com.bettermile.parcelshop.util.ApplicationLogger.info
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppStartupRunner(private val parcelRepository: ParcelRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        info("Your application started with option names : ${args.optionNames}")
        parcelRepository.saveAll(
            listOf(
                Parcel(
                    address = Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785"),
                    parcelNumber = "1000",
                    deliveryDate = "20200421",
                    deliveryState = DeliveryState.OUT_FOR_DELIVERY
                ),
                Parcel(
                    address = Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785"),
                    parcelNumber = "1001",
                    deliveryDate = "20200421",
                    deliveryState = DeliveryState.OUT_FOR_DELIVERY
                ),
                Parcel(
                    address = Address(
                        consignee = "Max Mustermann",
                        street = "Weinbergsweg",
                        number = "2",
                        zip = "10119"
                    ),
                    parcelNumber = "1002",
                    deliveryDate = "20200421",
                    deliveryState = DeliveryState.OUT_FOR_DELIVERY
                ),
                Parcel(
                    address = Address(consignee = "Hans Meier", street = "Weinbergsweg", number = "3", zip = "10119"),
                    parcelNumber = "1003",
                    deliveryDate = "20200421",
                    deliveryState = DeliveryState.DELIVERED
                ),
                Parcel(
                    address = Address(consignee = "GLS", street = "Kemperplatz", number = "1", zip = "10785"),
                    parcelNumber = "1004",
                    deliveryDate = "20200420",
                    deliveryState = DeliveryState.READY_FOR_DELIVERY
                )
            )
        )
    }
}
