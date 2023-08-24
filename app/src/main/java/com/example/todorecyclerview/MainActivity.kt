package com.example.todorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todorecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        var todoList = mutableListOf(
            Todo("Task 1", false),
            Todo("Task 2", true),
            Todo("Task 3", false),
            Todo("Task 4", true),
            Todo("Task 5", false),
            Todo("Task 6", true),
            Todo("Task 7", false),
        )
        val adapter = TodoAdapter(todoList)
        var rvTodos : RecyclerView = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener{
            val title = findViewById<EditText>(R.id.etTodo).text.toString()
            findViewById<EditText>(R.id.etTodo).setText("")
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }

    }
}