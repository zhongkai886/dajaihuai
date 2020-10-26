package com.example.user.dajaihuai

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter constructor(context: Context
):RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){

    private val inflater:LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<UserData>()

    inner class  UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textAppName:TextView = itemView.findViewById(R.id.textAppName)
        val textAccount:TextView = itemView.findViewById(R.id.textAccount)
        val textPassword:TextView = itemView.findViewById(R.id.textPassword)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
     val current = users[position]
        holder.textAppName.text = current.name
        holder.textAccount.text = current.account
        holder.textPassword.text = current.password
    }

    internal fun setUsers(users:List<UserData>){
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size



}