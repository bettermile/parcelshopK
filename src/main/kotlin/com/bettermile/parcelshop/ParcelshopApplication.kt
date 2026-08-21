package com.bettermile.parcelshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = ["com.bettermile.parcelshop.repository"])
@EntityScan(basePackages = ["com.bettermile.parcelshop.model"])
open class ParcelshopApplication

fun main(args: Array<String>) {
    runApplication<ParcelshopApplication>(*args)
}