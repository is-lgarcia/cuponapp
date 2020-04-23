package com.luisg.cuponapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.luisg.cuponapp.R
import com.luisg.cuponapp.databinding.ActivityMainBinding
import com.luisg.cuponapp.model.Coupon
import com.luisg.cuponapp.viewmodel.CouponViewModel

class MainActivity : AppCompatActivity(){

    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?){
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        couponViewModel = ViewModelProvider.NewInstanceFactory().create(CouponViewModel::class.java)

        activityMainBinding.setModel(couponViewModel)
        setupListUpdate()
    }

    fun setupListUpdate(){
        couponViewModel?.callCoupon()
        couponViewModel?.getCoupons()?.observe(this, Observer { coupons: List<Coupon> ->
            Log.w("COUPON", coupons.get(0).title)
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
        })
    }

}
