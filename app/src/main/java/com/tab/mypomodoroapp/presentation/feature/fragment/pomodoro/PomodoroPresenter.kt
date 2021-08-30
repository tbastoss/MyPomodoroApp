package com.tab.mypomodoroapp.presentation.feature.fragment.pomodoro

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
import com.tab.mypomodoroapp.presentation.feature.fragment.countdown.CountDownFragment
import com.tab.mypomodoroapp.framework.navigationAPI.NavigationAPIContract

class PomodoroPresenter(
    private val view: NavigationAPIContract.NavigationAPIView,
    private val pomodoroView: PomodoroContract.PomodoroView,
    private val context: Context,
    private val notificationManager: NotificationManager

) : PomodoroContract.ṔomodoroPresenter {
    override fun loadPomodoroElements(countDownFragment: CountDownFragment) {
        view.changeFragment(countDownFragment)
    }

    override fun setDonNotDisturbOn() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            changeInterruptionFiler()
        } else {
            pomodoroView.alertNotAllowedToTurnOnDonNotDisturb()
        }
    }

    private fun changeInterruptionFiler() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // If api level minimum 23
            /*
                boolean isNotificationPolicyAccessGranted ()
                    Checks the ability to read/modify notification policy for the calling package.
                    Returns true if the calling package can read/modify notification policy.
                    Request policy access by sending the user to the activity that matches the
                    system intent action ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS.

                    Use ACTION_NOTIFICATION_POLICY_ACCESS_GRANTED_CHANGED to listen for
                    user grant or denial of this access.

                Returns
                    boolean

            */
            // If notification policy access granted for this package
            if (notificationManager.isNotificationPolicyAccessGranted()) {
                /*
                    void setInterruptionFilter (int interruptionFilter)
                        Sets the current notification interruption filter.

                        The interruption filter defines which notifications are allowed to interrupt
                        the user (e.g. via sound & vibration) and is applied globally.

                        Only available if policy access is granted to this package.

                    Parameters
                        interruptionFilter : int
                        Value is INTERRUPTION_FILTER_NONE, INTERRUPTION_FILTER_PRIORITY,
                        INTERRUPTION_FILTER_ALARMS, INTERRUPTION_FILTER_ALL
                        or INTERRUPTION_FILTER_UNKNOWN.
                */

                // Set the interruption filter
                notificationManager.setInterruptionFilter(
                    NotificationManager.INTERRUPTION_FILTER_NONE);
            } else {
                /*
                    String ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS
                        Activity Action : Show Do Not Disturb access settings.
                        Users can grant and deny access to Do Not Disturb configuration from here.

                    Input : Nothing.
                    Output : Nothing.
                    Constant Value : "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"
                */
                // If notification policy access not granted for this package
                val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
                startActivity(context, intent, null)
            }
        }
    }
}
