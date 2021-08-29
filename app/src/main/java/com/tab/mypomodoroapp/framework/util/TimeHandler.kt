package com.tab.mypomodoroapp.framework.util

import android.os.Handler

class TimeHandler {
    fun callMe(time: Long, callback: () -> Unit) {
        Handler().postDelayed({
            callback()
        }, time)
    }
}