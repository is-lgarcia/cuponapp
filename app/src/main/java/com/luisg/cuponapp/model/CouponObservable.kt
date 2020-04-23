package com.luisg.cuponapp.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {

    private var couponRepository: CouponRepository = CouponRepositoryImpl()

    //Repository
    fun callCoupons(){
        couponRepository.callCouponsAPI()
    }
    //ViewModel
    fun getCoupons(): MutableLiveData<List<Coupon>>{
        return couponRepository.getCoupons()
    }
}