package com.example.sis4.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sis4.data.Post
import com.example.sis4.databinding.ItemPostBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.VH>() {
    private val items = mutableListOf<Post>()

    fun submit(list: List<Post>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    class VH(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val p = items[position]
        holder.binding.title.text = p.title
        holder.binding.body.text = p.body
    }

    override fun getItemCount() = items.size
}
