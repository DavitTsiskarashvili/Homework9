package com.example.homework9

import androidx.recyclerview.widget.DiffUtil

class DiffUtil(
    private val oldList: List<User>,
    private val newList: List<User>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }
            oldList[oldItemPosition].surname != newList[newItemPosition].surname -> {
                false
            }
            oldList[oldItemPosition].email != newList[newItemPosition].email -> {
                false
            }
            else -> true
        }
    }

}