package com.tab.mypomodoroapp.presentation.feature.fragment.startPomodoro

import com.tab.mypomodoroapp.framework.navigationAPI.NavigationAPIContract

interface StartPomodoroContract {
    interface StartPomodoroPresenter {
        fun callToShowToast(text: String)
        fun callNavigationAPI(activity: NavigationAPIContract.NavigationAPIView)
    }

    interface StartPomodoroView {
        fun showToast(text: String)
    }
}