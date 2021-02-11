package com.tab.mypomodoroapp.ui.splash

interface SplashContract {
    interface SplachPresenter {
        fun init()
    }

    interface SplashView {
        fun openInitialScreen()
    }
}