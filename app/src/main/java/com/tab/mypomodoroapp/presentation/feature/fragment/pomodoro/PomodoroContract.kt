package com.tab.mypomodoroapp.presentation.feature.fragment.pomodoro

import com.tab.mypomodoroapp.presentation.feature.fragment.countdown.CountDownFragment

interface PomodoroContract {
    interface ṔomodoroPresenter {
        fun loadPomodoroElements(countDownFragment: CountDownFragment)
        fun setDonNotDisturbOn()
    }

    interface PomodoroView {
        fun alertNotAllowedToTurnOnDonNotDisturb()

    }
}