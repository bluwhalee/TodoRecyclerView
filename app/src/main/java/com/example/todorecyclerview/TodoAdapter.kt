package com.example.todorecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (var todos:List<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        var constraintLayout1: ConstraintLayout = itemView.findViewById<ConstraintLayout>(R.id.todoCont)
        init{
            itemView.setOnClickListener{View ->
                Toast.makeText(itemView.context,itemView.findViewById<TextView>(R.id.tvTitle).text.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvTitle).apply{
            this.text = todos[position].title
        }
        holder.itemView.findViewById<CheckBox>(R.id.cbDone).apply{
            this.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}