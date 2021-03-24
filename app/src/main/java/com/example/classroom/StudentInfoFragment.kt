package com.example.classroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_student_info.*

class StudentInfoFragment : Fragment() {

    lateinit var listener:StudentInfoFragmentListener
    lateinit var student: Student
    lateinit var gradeAdapter: GradeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_student_info, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        age_text_info.text = student.age.toString()
        name_text_info.text = student.name
        surname_text_info.text = student.surname

        gradeAdapter = GradeAdapter(student.grades)
        grades_recycler.layoutManager = LinearLayoutManager(context)
        grades_recycler.adapter = gradeAdapter
        gradeAdapter.notifyDataSetChanged()

        add_grade_button.setOnClickListener {
            listener.onCreateGradeButtonClicked()
        }

    }


    fun notifyDataChanged(){
        gradeAdapter.notifyDataSetChanged()
    }


    interface StudentInfoFragmentListener {

       fun onCreateGradeButtonClicked()
    }

}