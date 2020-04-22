package com.luisg.cuponapp.presenter

import com.luisg.cuponapp.model.Coupon

interface CouponPresenter {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)
    //Interactor
    fun gerCoupons()
}