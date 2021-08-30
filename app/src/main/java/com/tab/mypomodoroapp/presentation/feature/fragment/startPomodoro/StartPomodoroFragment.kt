package com.tab.mypomodoroapp.presentation.feature.fragment.startPomodoro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.tab.mypomodoroapp.R
import com.tab.mypomodoroapp.framework.navigationAPI.NavigationAPIContract

/**
 * A simple [Fragment] subclass.
 */
class StartPomodoroFragment : Fragment(), StartPomodoroContract.StartPomodoroView {

    lateinit var presenter: StartPomodoroPresenter
    lateinit var startPomodoroBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_start_pomodoro,
            container, false)

        presenter = StartPomodoroPresenter(this)

        startPomodoroBtn = view.findViewById(R.id.btn_start_pomodoro)
        startPomodoroBtn.setOnClickListener {
            presenter.callNavigationAPI(activity as NavigationAPIContract.NavigationAPIView)
            presenter.callToShowToast("Pomodoro will start in a fill seconds")
        }
        return view
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}
