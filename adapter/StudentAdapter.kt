package com.example.mvvmlistview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlistview.model.Student
import com.example.mvvmlistview.databinding.ItemLayoutBinding


class StudentAdapter(val context:Context,val list:List<Student>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        return StudentViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return list.size//To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StudentViewHolder).bindData(holder,position)
    }

    inner class StudentViewHolder(var itemRowBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemRowBinding.getRoot()) {

        fun bindData(holder: RecyclerView.ViewHolder,position: Int) {
            itemRowBinding.model=list[position]
        }
    }

}