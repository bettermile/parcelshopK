package com.bettermile.parcelshop.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateTimeUtil {
    const val DATE_FORMAT_PATTERN = "yyyyMMdd"

    fun getFormattedDate(date: String) =
        runCatching {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(com.bettermile.parcelshop.util.DateTimeUtil.DATE_FORMAT_PATTERN))
        }.onFailure {
            com.bettermile.parcelshop.util.ApplicationLogger.error(
                message = "Could not parse date",
                throwable = it
            )
        }
}