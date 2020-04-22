package com.luisg.cuponapp.model

import android.util.Log
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.luisg.cuponapp.R
import com.luisg.cuponapp.presenter.CouponPresenter
import com.luisg.cuponapp.view.RecyclerCouponsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(var couponPresenter: CouponPresenter): CouponRepository {

    override fun getCouponsAPI() {

        //CONTROLLER
        val coupons: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdaper = ApiAdapter()
        val apiService = apiAdaper.getClientService()
        val call = apiService.getCoupons()
        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    coupons?.add(coupon)
                }
                //VIEW
                couponPresenter.showCoupons(coupons)
            }

        })
    }
}