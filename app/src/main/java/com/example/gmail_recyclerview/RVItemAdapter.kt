package com.example.gmail_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class RVItemAdapter(val items: ArrayList<ItemModel>): RecyclerView.Adapter<RVItemAdapter.RVItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVItemAdapter.RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)

        return RVItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RVItemAdapter.RVItemViewHolder, position: Int) {
        holder.textN.text = items[position].name[0].toString()
        holder.textName.text = items[position].name
        holder.textContent.text = items[position].content
        holder.textTime.text = items[position].time
        holder.checkSelected.isChecked = items[position].selected

        holder.checkSelected.setOnClickListener {
            items[position].selected = (it as CheckBox).isChecked
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items.size

    class RVItemViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){
        val textN: TextView
        val textName: TextView
        val textContent: TextView
        val textTime: TextView
        val checkSelected: CheckBox
        init {
            textN = itemView.findViewById(R.id.text_n)
            textName = itemView.findViewById(R.id.text_name)
            textContent = itemView.findViewById(R.id.text_content)
            textTime = itemView.findViewById(R.id.text_time)
            checkSelected = itemView.findViewById(R.id.check_selected)
        }
    }
}