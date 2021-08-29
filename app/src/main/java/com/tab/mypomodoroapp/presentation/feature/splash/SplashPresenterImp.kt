package com.tab.mypomodoroapp.presentation.feature.splash

import android.util.Log
import com.tab.mypomodoroapp.framework.util.TimeHandler

class SplashPresenterImp constructor(
    private val splashView: SplashContract.SplashView,
    private val timeHandler: TimeHandler
) : SplashContract.SplachPresenter {

    override fun init() {
        timeHandler.callMe(1500, callback = {
            Log.d("TEST", "inside handler")
            splashView.openInitialScreen()
        })
        Log.d("TEST", "outside handler")
    }
}