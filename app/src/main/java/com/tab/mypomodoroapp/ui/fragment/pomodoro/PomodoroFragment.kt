package com.tab.mypomodoroapp.ui.fragment.pomodoro

import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.tab.mypomodoroapp.R
import com.tab.mypomodoroapp.ui.fragment.countdown.CountDownFragment
import com.tab.mypomodoroapp.ui.navigationAPI.NavigationAPIContract


class PomodoroFragment : Fragment(),
    PomodoroContract.PomodoroView, NavigationAPIContract.NavigationAPIView {

    lateinit var presenter: PomodoroContract.ṔomodoroPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pomodoro_follow_up,
            container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val notificationManager = context.getSystemService(
            NOTIFICATION_SERVICE) as NotificationManager
        presenter = PomodoroPresenter(this, this, context, notificationManager)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.loadPomodoroElements(CountDownFragment())
        presenter.setDonNotDisturbOn()
    }

    override fun changeFragment(fragment: Fragment) {
        Toast.makeText(activity, "YEAH", Toast.LENGTH_SHORT).show()
    }

    override fun alertNotAllowedToTurnOnDonNotDisturb() {
        Toast.makeText(activity,
            "This Device doesn't allow Do Not Disturb Mode", Toast.LENGTH_LONG).show()
    }

}
