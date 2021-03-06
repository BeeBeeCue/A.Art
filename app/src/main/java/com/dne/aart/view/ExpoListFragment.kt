package com.dne.aart.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dne.aart.R
import com.dne.aart.util.AdoptiveListAdapter
import kotlinx.android.synthetic.main.fragment_expo_list.*

class ExpoListFragment : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private var isAdmin: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (arguments != null ) isAdmin = arguments!!.getBoolean("isAdmin")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // configuring the adapter for exhibitions list view
        linearLayoutManager = LinearLayoutManager(activity!!.applicationContext)
        rcv.layoutManager = linearLayoutManager
        rcv.adapter = AdoptiveListAdapter(context!!,null, isAdmin)

        // show divider between list items
        val dividerItemDecoration = DividerItemDecoration(
            rcv.context,
            linearLayoutManager.orientation
        )
        rcv.addItemDecoration(dividerItemDecoration)
    }
}
