package com.example.bismilahcrud.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bismilahcrud.R
import com.example.bismilahcrud.model.DataItem
import kotlinx.android.synthetic.main.activity_item_data.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class DataAdapter(val data: String?, private val click:onClickItem) : RecyclerView.Adapter<DataAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_data,parent, false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ? : 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.onClick {
            click.clicked(data?.get(position))
        }
        holder.itemView.btnHapus.setOnClickListener {
            click.delete(data?.get((position)))
        }
    }

    class MyHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        fun onBind(get: DataItem?) {
                itemView.tvName.text = get?.staffName
                itemView.tvPhone.text = get?.staffHp
                itemView.tvAddress.text = get?.staffAlamat
            }
        }

    interface onClickItem{
        fun clicked (item: DataItem?)
        fun delete(item: DataItem?)
    }

}