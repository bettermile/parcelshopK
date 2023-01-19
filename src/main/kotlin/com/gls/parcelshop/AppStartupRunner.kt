package com.gls.parcelshop

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import com.gls.parcelshop.model.DeliveryState
import javax.persistence.JoinColumn
import com.gls.parcelshop.model.Parcel
import lombok.extern.slf4j.Slf4j
import com.gls.parcelshop.service.NotificationService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import com.gls.parcelshop.repository.ParcelRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.data.repository.CrudRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.ApplicationArguments
import com.gls.parcelshop.AppStartupRunner
import com.gls.parcelshop.model.Address
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.stereotype.Component
import java.util.*

@Slf4j
@Component
class AppStartupRunner : ApplicationRunner {
    @Autowired
    private val parcelRepository: ParcelRepository? = null
    override fun run(args: ApplicationArguments) {
        AppStartupRunner.log.info("Your application started with option names : {}", args.optionNames)
        parcelRepository!!.saveAll(
            Arrays.asList(
                Parcel.builder()
                    .address(
                        Address.builder()
                            .consignee("GLS")
                            .street("Kemperplatz")
                            .number("1")
                            .zip("10785")
                            .build()
                    )
                    .deliveryState(DeliveryState.OUT_FOR_DELIVERY)
                    .parcelNumber("1000")
                    .deliveryDate("20200421")
                    .build(),
                Parcel.builder()
                    .address(
                        Address.builder()
                            .consignee("GLS")
                            .street("Kemperplatz")
                            .number("1")
                            .zip("10785")
                            .build()
                    )
                    .deliveryState(DeliveryState.OUT_FOR_DELIVERY)
                    .parcelNumber("1001")
                    .deliveryDate("20200421")
                    .build(),
                Parcel.builder()
                    .address(
                        Address.builder()
                            .consignee("Max Mustermann")
                            .street("Weinbergsweg")
                            .number("2")
                            .zip("10119")
                            .build()
                    )
                    .deliveryState(DeliveryState.OUT_FOR_DELIVERY)
                    .parcelNumber("1002")
                    .deliveryDate("20200421")
                    .build(),
                Parcel.builder()
                    .address(
                        Address.builder()
                            .consignee("Hans Meier")
                            .street("Weinbergsweg")
                            .number("3")
                            .zip("10119")
                            .build()
                    )
                    .deliveryState(DeliveryState.DELIVERED)
                    .parcelNumber("1003")
                    .deliveryDate("20200421")
                    .build(),
                Parcel.builder()
                    .address(
                        Address.builder()
                            .consignee("GLS")
                            .street("Kemperplatz")
                            .number("1")
                            .zip("10785")
                            .build()
                    )
                    .deliveryState(DeliveryState.READY_FOR_DELIVERY)
                    .parcelNumber("1000")
                    .deliveryDate("20200420")
                    .build()
            )
        )
    }
}