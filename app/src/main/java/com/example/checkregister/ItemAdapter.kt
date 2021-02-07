package com.example.checkregister

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkregister.databinding.ItemListBinding
import com.example.checkregister.model.ItemEntity

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemVH>(){
    private var listItem = listOf<ItemEntity>()

    fun update(list: List<ItemEntity>){
        listItem = list
        notifyDataSetChanged()
    }

    inner class ItemVH(private val mBinding: ItemListBinding) :
        RecyclerView.ViewHolder(mBinding.root){
        fun bind(item:ItemEntity){
            mBinding.tvItem.text = item.nombre
            mBinding.tvCantidad.text = item.ctd.toString()
            mBinding.tvTotalRV.text = item.total.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        return ItemVH(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }
}