package com.bettermile.parcelshop.service

import com.bettermile.parcelshop.model.Parcel
import com.bettermile.parcelshop.util.ApplicationLogger.info
import org.springframework.stereotype.Service


@Service
class NotificationService {
    suspend fun notifySomeoneAboutChange(parcel: Parcel) {
        info("Notification about parcel: $parcel")
    }
}
