package com.example.nubank.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nubank.R
import com.example.nubank.model.MenuOptions

class HomeViewModel : ViewModel() {
    private val mOptionsList = MutableLiveData<List<MenuOptions>>()
    val optionsList: LiveData<List<MenuOptions>> = mOptionsList

    var menu = listOf(
        MenuOptions(R.drawable.ic__transferencia, "Transferencia"),
        MenuOptions(R.drawable.ic_deposito,"Deposito"))

    fun setMenu() {
        mOptionsList.value = menu
    }
}