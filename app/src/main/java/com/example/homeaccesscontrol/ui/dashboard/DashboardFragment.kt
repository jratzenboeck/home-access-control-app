package com.example.homeaccesscontrol.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.homeaccesscontrol.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)


        val textSwitcher: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textSwitcher.text = it
        })

        val textMarc: TextView = root.findViewById(R.id.text_input_dashboard)
        dashboardViewModel.marc.observe(this, Observer {
            textMarc.text = it
        })
        val buttonPushMe: Button = root.findViewById(R.id.button_input_dashboard)
        dashboardViewModel.pushMe.observe(this, Observer {
            buttonPushMe.text = it
        })
        // fetchJSON()
        return root
    }
}
