package com.tab.mypomodoroapp.ui.splash

import android.util.Log
import com.tab.mypomodoroapp.util.TimeHandler

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