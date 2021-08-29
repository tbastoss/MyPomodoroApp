package com.tab.mypomodoroapp.presentation.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tab.mypomodoroapp.R
import com.tab.mypomodoroapp.framework.navigationAPI.NavigationAPIActivity
import com.tab.mypomodoroapp.framework.util.TimeHandler

class SplashActivity : AppCompatActivity(), SplashContract.SplashView {

    private lateinit var presenter: SplashContract.SplachPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = SplashPresenterImp(this, TimeHandler())
        presenter.init()
    }

    override fun openInitialScreen() {
        startActivity(Intent(this, NavigationAPIActivity::class.java))
    }
}
