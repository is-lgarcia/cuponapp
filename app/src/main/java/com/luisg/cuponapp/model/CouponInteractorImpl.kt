package com.luisg.cuponapp.model

import com.luisg.cuponapp.presenter.CouponPresenter

class CouponInteractorImpl(var couponPresenter: CouponPresenter): CouponsInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}