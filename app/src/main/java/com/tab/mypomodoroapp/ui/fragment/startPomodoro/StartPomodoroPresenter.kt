package com.tab.mypomodoroapp.ui.fragment.startPomodoro

import com.tab.mypomodoroapp.ui.fragment.pomodoro.PomodoroFragment
import com.tab.mypomodoroapp.ui.navigationAPI.NavigationAPIContract

class StartPomodoroPresenter (
    private val view: StartPomodoroContract.StartPomodoroView
): StartPomodoroContract.StartPomodoroPresenter {
    override fun callToShowToast(text: String) {
        view.showToast(text)
    }

    override fun callNavigationAPI(activity: NavigationAPIContract.NavigationAPIView) {
        activity.changeFragment(PomodoroFragment())
    }
}