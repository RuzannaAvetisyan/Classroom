package com.example.classroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter(var studentsList: MutableList<Student>) :
    RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {


    lateinit var listener : StudentsListAdapterItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.student_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(studentsList[position], position)

        holder.itemView.setOnClickListener {
            listener.onItemClicked(position, studentsList[position])
        }
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun init(student: Student, position: Int) {
            itemView.apply {
                findViewById<TextView>(R.id.student_number).text = position.toString()
                findViewById<TextView>(R.id.student_name).text = student.name
                findViewById<TextView>(R.id.student_surname).text = student.surname
                findViewById<TextView>(R.id.student_age).text = student.age.toString()
            }
        }
    }

    interface StudentsListAdapterItemClickListener {
        fun onItemClicked(position: Int, student: Student)

    }

}