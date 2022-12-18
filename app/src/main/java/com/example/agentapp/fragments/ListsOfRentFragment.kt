package com.example.agentapp.fragments

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.agentapp.R
import com.example.agentapp.activities.AddDetailActivity
import kotlinx.android.synthetic.main.fragment_lists_of_rent.*

class ListsOfRentFragment : Fragment() {
    private lateinit var btnNext : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_lists_of_rent, container, false)

        btnNext = view.findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_navigation_Lists_of_rent_to_addDetailActivity)
        }

        return view
/*        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lists_of_rent, container, false)
*/
    }


}