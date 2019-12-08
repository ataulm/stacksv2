package com.ataulm.stacks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

internal class StacksAdapter : ListAdapter<StacksAdapter.Item, ItemViewHolder>(Differ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stacks_adapter_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        (holder.itemView as TextView).text = getItem(position).text
    }

    data class Item(val text: CharSequence)
}

internal class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

private object Differ : DiffUtil.ItemCallback<StacksAdapter.Item>() {
    override fun areItemsTheSame(oldItem: StacksAdapter.Item, newItem: StacksAdapter.Item) = oldItem == newItem
    override fun areContentsTheSame(oldItem: StacksAdapter.Item, newItem: StacksAdapter.Item) = oldItem.text == newItem.text
}
