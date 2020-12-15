package com.msiazn.kotlinbirthday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.msiazn.kotlinbirthday.databinding.SingleItemBinding
import org.jetbrains.annotations.NonNls

class SingleItemAdapter(
    @NonNls private val dataSource: List<SingleItem>,
    @NonNls private val listener: onSingleItemClickListener
) :
    RecyclerView.Adapter<SingleItemAdapter.SingleItemViewHolder>() {
    private var _binding: SingleItemBinding? = null
    private val binding get() = _binding!!


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleItemViewHolder {
        _binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SingleItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SingleItemViewHolder, position: Int) {
        val currentItem = dataSource[position]
        holder.image.setImageResource(currentItem.imageResource)
        holder.text0.text = currentItem.text1
        holder.text1.text = currentItem.text2
    }

    override fun getItemCount() = dataSource.size


    inner class SingleItemViewHolder(binding1: SingleItemBinding) :
        RecyclerView.ViewHolder(binding1.root), View.OnClickListener {
        val image: ImageView = binding1.image
        val text0: TextView = binding1.tv0
        val text1: TextView = binding1.tv1

        init {
            binding1.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onSingleItemClick(position)
            }
        }
    }

    interface onSingleItemClickListener {
        fun onSingleItemClick(position: Int)
    }
}

