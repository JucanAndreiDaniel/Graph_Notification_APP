package com.example.scfnotification.data.entities

import android.annotation.SuppressLint
import androidx.room.*

@SuppressLint("RestrictedApi")
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CryptoCoin::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("coin"),
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = arrayOf("coin"))]
)
class CoinValue(
    coin_currency: String,
    coin: String,
    currency: String,
    current: Double,
    high_1d: Double,
    low_1d: Double,
    ath: Double,
    atl: Double,
    ath_time: String,
    atl_time: String
) {

    @PrimaryKey
    @ColumnInfo(name = "coin_currency")
    var coin_currency: String = coin_currency

    @ColumnInfo(name = "coin")
    var coin: String = coin

    @ColumnInfo(name = "currency")
    var currency: String = currency

    @ColumnInfo(name = "current")
    var current: Double = current

    @ColumnInfo(name = "high_1d")
    var high_1d: Double = high_1d

    @ColumnInfo(name = "low_1d")
    var low_1d: Double = low_1d

    @ColumnInfo(name = "ath")

    var ath: Double = ath

    @ColumnInfo(name = "ath_time")
    var ath_time: String = ath_time

    @ColumnInfo(name = "atl")
    var atl: Double = atl

    @ColumnInfo(name = "atl_time")
    var atl_time: String = atl_time
}
