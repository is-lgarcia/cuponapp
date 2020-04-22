package com.luisg.cuponapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.luisg.cuponapp.model.Coupon
import com.luisg.cuponapp.R
import com.luisg.cuponapp.model.ApiAdapter
import com.luisg.cuponapp.presenter.CouponPresenter
import com.luisg.cuponapp.presenter.CouponPresenterImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter? = null
    var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        //VIEW
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    override fun getCoupons() {
        couponPresenter?.gerCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons,R.layout.card_coupon)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

}
