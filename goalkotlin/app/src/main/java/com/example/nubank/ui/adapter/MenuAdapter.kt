package com.example.nubank.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nubank.R
import com.example.nubank.model.MenuOptions
import kotlinx.android.synthetic.main.card_menu.view.*

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.GuestViewHolder>() {

    private var guestList: List<MenuOptions> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_menu, parent,false)
        return GuestViewHolder(item)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun addAll(list: List<MenuOptions>) {
        guestList = list
        notifyDataSetChanged()

    }

    class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(options: MenuOptions) {
            itemView.card_menu_img.setBackgroundResource(options.icon)
            itemView.card_menu_textView.text = options.options
        }
    }
}
