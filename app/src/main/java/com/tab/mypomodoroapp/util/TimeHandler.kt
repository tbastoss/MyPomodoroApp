package com.tab.mypomodoroapp.util

import android.os.Handler

class TimeHandler {
    fun callMe(time: Long, callback: () -> Unit) {
        Handler().postDelayed({
            callback()
        }, time)
    }
}