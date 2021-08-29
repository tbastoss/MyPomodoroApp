package com.tab.mypomodoroapp.presentation.feature.splash

interface SplashContract {
    interface SplachPresenter {
        fun init()
    }

    interface SplashView {
        fun openInitialScreen()
    }
}