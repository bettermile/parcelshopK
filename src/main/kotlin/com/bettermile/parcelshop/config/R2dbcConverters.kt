package com.bettermile.parcelshop.config

import com.bettermile.parcelshop.model.DeliveryState
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component

@Component
@WritingConverter
class DeliveryStateWritingConverter : Converter<DeliveryState, String> {
    override fun convert(source: DeliveryState): String = source.name
}

@Component
@ReadingConverter
class DeliveryStateReadingConverter : Converter<String, DeliveryState> {
    override fun convert(source: String): DeliveryState = DeliveryState.valueOf(source)
}
