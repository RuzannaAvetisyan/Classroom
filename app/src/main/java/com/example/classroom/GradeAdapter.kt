package com.example.classroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GradeAdapter(val grades: MutableList<Grade>) :
    RecyclerView.Adapter<GradeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.grades_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(grades[position], position)
    }

    override fun getItemCount(): Int {
        return grades.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun init(grade: Grade, position: Int) {
            itemView.apply {
                findViewById<TextView>(R.id.grade).text = grade.grade.toString()
                findViewById<TextView>(R.id.grade_date).text = grade.date
                findViewById<TextView>(R.id.grade_subject).text = grade.subject
                findViewById<TextView>(R.id.grade_number).text = position.toString()
            }

        }
    }
}