package com.example.homework9

import android.os.Bundle
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import com.example.homework9.databinding.ActivityMainBinding
import com.example.homework9.databinding.UserinfoBinding

class Adapter(private var oldUserList: MutableList<User>) : RecyclerView.Adapter<Adapter.UserViewHolder>() {

    private lateinit var binding: UserinfoBinding
    private lateinit var adapter: Adapter

    inner class UserViewHolder(val binding: UserinfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun removeUser(user: User, index: Int) {
            binding.btnRemove.setOnClickListener { deleteItem(index) }
        }

        fun updateUser(user: User, index: Int) {
            binding.btnChange.setOnClickListener()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserinfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.tvName.text = oldUserList[position].name
        holder.binding.tvSurName.text = oldUserList[position].surname
        holder.binding.tvEmail.text = oldUserList[position].email
        holder.removeUser(oldUserList[position], position)
    }

    override fun getItemCount(): Int {
        return oldUserList.size
    }

    fun deleteItem(index: Int) {
        oldUserList.removeAt(index)
        notifyItemRemoved(index)
    }


    fun updateUser(){}


    fun setData(newUserList: MutableList <User>){
        val diffUtil = DiffUtil(oldUserList, newUserList)
        val diffResults = androidx.recyclerview.widget.DiffUtil.calculateDiff(diffUtil)
        oldUserList = newUserList
        diffResults.dispatchUpdatesTo(this)
    }

}


