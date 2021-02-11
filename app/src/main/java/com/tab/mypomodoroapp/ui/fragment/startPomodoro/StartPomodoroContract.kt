package com.tab.mypomodoroapp.ui.fragment.startPomodoro

import com.tab.mypomodoroapp.ui.navigationAPI.NavigationAPIContract

interface StartPomodoroContract {
    interface StartPomodoroPresenter {
        fun callToShowToast(text: String)
        fun callNavigationAPI(activity: NavigationAPIContract.NavigationAPIView)
    }

    interface StartPomodoroView {
        fun showToast(text: String)
    }
}