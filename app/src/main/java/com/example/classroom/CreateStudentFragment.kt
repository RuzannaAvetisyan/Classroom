package com.example.classroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_student.*

class CreateStudentFragment : DialogFragment() {

    lateinit var listener:CreateStudentFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        student_add_button.setOnClickListener {
            val student = Student(
                student_name_edit.text.toString(),
                student_surname_edit.text.toString(),
                student_age_edit.text.toString().toInt()
            )

            listener.onStudentCreated(student)
        }
    }


    interface CreateStudentFragmentListener{
        fun onStudentCreated(student:Student)
    }

}