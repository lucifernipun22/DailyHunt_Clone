package com.example.dailyhunt_clone.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dailyhunt_clone.R


class CoronaVirusFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_corona_virus, container, false)
    }

    companion object {
        fun newInstance(): CoronaVirusFragment {
            return CoronaVirusFragment()
        }
    }
}