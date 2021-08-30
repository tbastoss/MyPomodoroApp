package com.tab.mypomodoroapp.framework.navigationAPI

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.tab.mypomodoroapp.R
import com.tab.mypomodoroapp.presentation.feature.fragment.startPomodoro.StartPomodoroFragment

class NavigationAPIActivity : FragmentActivity(), NavigationAPIContract.NavigationAPIView {

    private lateinit var presenter: NavigationAPIContract.NavigationAPIPersenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)

        val notificationManager = applicationContext.getSystemService(
            Context.NOTIFICATION_SERVICE) as NotificationManager
        presenter = NavigationAPIPresenterImp(applicationContext,
            this, notificationManager)

        presenter.updateView(StartPomodoroFragment())
    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.turnOffDoNotDisturb()
    }
}
