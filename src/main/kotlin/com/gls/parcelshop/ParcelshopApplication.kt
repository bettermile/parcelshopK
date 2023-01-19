package com.gls.parcelshop

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object ParcelshopApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(ParcelshopApplication::class.java, *args)
    }
}