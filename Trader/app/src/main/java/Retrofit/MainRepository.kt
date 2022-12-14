package Retrofit

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainRepository {
    private val apiServices:ApiServices
        companion object{
            const val Tag="MainRep"
        }
    init { apiServices=Common.getApiService
    }
    var cryptoLiveData= MutableLiveData<MutableList<ApiData>>()
    var newLiveData=cryptoLiveData as LiveData<List<ApiData>>

    suspend fun getCryptoList():List<ApiData>? {

        try {
            var result = apiServices.getApiServices(0, 15)
            return result.body()
        } catch (e: Exception) {
            Log.e("Exception Tag", e.localizedMessage ?: "")
        }
        return  null
    }
}

