package com.tab.mypomodoroapp.framework.navigationAPI

import androidx.fragment.app.Fragment

interface NavigationAPIContract {
    interface NavigationAPIPersenter {
        fun updateView(fragment: Fragment)
        fun turnOffDoNotDisturb()
    }

    interface NavigationAPIView {
        fun changeFragment(fragment: Fragment)
    }
}