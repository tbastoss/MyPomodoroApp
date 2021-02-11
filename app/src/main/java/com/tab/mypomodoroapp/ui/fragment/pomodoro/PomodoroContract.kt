package com.tab.mypomodoroapp.ui.fragment.pomodoro

import com.tab.mypomodoroapp.ui.fragment.countdown.CountDownFragment

interface PomodoroContract {
    interface ṔomodoroPresenter {
        fun loadPomodoroElements(countDownFragment: CountDownFragment)
        fun setDonNotDisturbOn()
    }

    interface PomodoroView {
        fun alertNotAllowedToTurnOnDonNotDisturb()

    }
}