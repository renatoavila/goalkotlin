package com.example.nubank.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nubank.R
import com.example.nubank.ui.adapter.MenuAdapter
import com.example.nubank.ui.listener.BankListener
import com.example.nubank.ui.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private val menuAdapter: MenuAdapter = MenuAdapter()
    private lateinit var mListener: BankListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_menu.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler_menu.adapter = menuAdapter

        var i: Int = 0
        eye.setOnClickListener {
            if (i == 0) {
                eye.setBackgroundResource(R.drawable.ic_closed_eye)
                txtSaldo.visibility = View.GONE
                i++
            } else {
                eye.setBackgroundResource(R.drawable.ic_eye)
                txtSaldo.visibility = View.VISIBLE
                i=0
            }
        }

        observe()
        viewModel.setMenu()

        txtSaldo.text = "R$ 150,00"
    }

    private fun observe() {
        viewModel.optionsList.observe(viewLifecycleOwner, Observer {
            menuAdapter.addAll(it)
        })
    }
}