package com.luisg.cuponapp.view

import com.luisg.cuponapp.model.Coupon

interface CouponView {
    //Presentador
    fun getCoupons()
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)
}