package com.example.scfnotification.data.repositories

import android.content.Context
import com.example.scfnotification.data.AppDatabase
import com.example.scfnotification.data.entities.CoinValue
import com.example.scfnotification.data.entities.CoinWithValues
import com.example.scfnotification.data.entities.CryptoCoin
import com.example.scfnotification.data.sharedpreferences.IPreferenceHelper
import com.example.scfnotification.data.sharedpreferences.PreferenceManager
import com.example.scfnotification.network.CryptoCoinValueItem
import com.example.scfnotification.network.NetworkOperations
import kotlinx.coroutines.flow.Flow

class Repository {

    companion object {

        private var coinDatabase: AppDatabase? = null

        private var coinTableModel: Flow<List<CoinWithValues>>? = null

        private fun initializeDB(context: Context): AppDatabase {
            return AppDatabase.getDatabase(context)
        }

        suspend fun updateDB(context: Context) {
            val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(context) }
            coinDatabase = initializeDB(context)
            val data: List<CryptoCoinValueItem> =
                NetworkOperations().getcoins(preferenceHelper.getApiKey())
            val coins: MutableList<CryptoCoin> = mutableListOf()
            val values: MutableList<CoinValue> = mutableListOf()
            for (item in data) {
                val coin =
                    CryptoCoin(
                        id = item.coin_id,
                        name = item.name,
                        image = item.image,
                        symbol = item.symbol,
                        lastUpdated = item.last_updated,
                    )
                val value = CoinValue(
                    coin = item.coin_id,
                    ath = item.ath,
                    atl = item.atl,
                    ath_time = item.ath_time,
                    atl_time = item.atl_time,
                    current = item.current,
                    currency = "usd",
                    coin_currency = "usd_" + item.coin_id,
                    high_1d = item.high_1d,
                    low_1d = item.low_1d
                )
                coins += coin
                values += value
            }
            coinDatabase!!.CryptoCoinDao().insertAll(coins)
            coinDatabase!!.CoinValueDao().insertAll(values)
        }

        fun getFavs(context: Context): Flow<List<CoinWithValues>> {

            coinDatabase = initializeDB(context)

            coinTableModel = coinDatabase!!.CoinWithValuesDao().getFavorites(true)

            return coinTableModel as Flow<List<CoinWithValues>>
        }

        fun getCoinDetails(context: Context): Flow<List<CoinWithValues>> {

            coinDatabase = initializeDB(context)

            coinTableModel = coinDatabase!!.CoinWithValuesDao().getCoinslimit(100)

            return coinTableModel as Flow<List<CoinWithValues>>
        }
    }
}