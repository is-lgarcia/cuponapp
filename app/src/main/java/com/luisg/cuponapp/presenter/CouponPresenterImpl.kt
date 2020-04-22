package com.luisg.cuponapp.presenter

import com.luisg.cuponapp.model.Coupon
import com.luisg.cuponapp.model.CouponInteractorImpl
import com.luisg.cuponapp.model.CouponsInteractor
import com.luisg.cuponapp.view.CouponView

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CouponsInteractor = CouponInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun gerCoupons() {
        couponInteractor.getCouponsAPI()
    }
}