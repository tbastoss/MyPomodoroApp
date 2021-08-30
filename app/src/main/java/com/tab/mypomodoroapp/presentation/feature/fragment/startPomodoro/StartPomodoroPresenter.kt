package com.tab.mypomodoroapp.presentation.feature.fragment.startPomodoro

import com.tab.mypomodoroapp.presentation.feature.fragment.pomodoro.PomodoroFragment
import com.tab.mypomodoroapp.framework.navigationAPI.NavigationAPIContract

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