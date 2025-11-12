package com.example.sis2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PostAdapter(
    private val onLikeClick: (Int) -> Unit
) : ListAdapter<Post, PostAdapter.VH>(DIFF) {


    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem
        }
    }


    

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }


    class VH(itemView: View, private val onLikeClick: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val text: TextView = itemView.findViewById(R.id.text)
        private val like: ImageButton = itemView.findViewById(R.id.likeButton)


        fun bind(post: Post) {
            text.text = post.text
            Glide.with(image).load(post.imageUrl).into(image)
            like.setImageResource(if (post.liked) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline)
            like.setOnClickListener { onLikeClick(post.id) }
        }
    }
}