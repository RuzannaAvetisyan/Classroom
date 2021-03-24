package com.example.classroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_create_grade.*

class CreateGradeFragment : DialogFragment() {

    lateinit var listener: CreateGradeFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_grade, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        grade_add_button.setOnClickListener {
            val grade = Grade(
                grade_subject_edit.text.toString(),
                grade_date_edit.text.toString(),
                grade_edit.text.toString().toInt()
            )

            listener.onGradeCreated(grade)
        }
    }


    interface CreateGradeFragmentListener {
        fun onGradeCreated(grade: Grade)
    }
}