package com.example.classroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_students_list.*

class StudentsListFragment : Fragment() {

    lateinit var listener: StudentListFragmentListener
    private val studentsAdapter = StudentsAdapter(students)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_students_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        students_recycler_view.layoutManager = LinearLayoutManager(context)
        students_recycler_view.adapter = studentsAdapter
        studentsAdapter.notifyDataSetChanged()
        studentsAdapter.listener = object : StudentsAdapter.StudentsListAdapterItemClickListener {
            override fun onItemClicked(position: Int, student: Student) {
                listener.onStudentItemClicked(student)
            }
        }

        create_student_button.setOnClickListener {
            listener.onCreateStudentButtonClicked()
        }

    }


    fun notifyDataChanged() {
        studentsAdapter.notifyDataSetChanged()
    }


    interface StudentListFragmentListener {
        fun onCreateStudentButtonClicked()

        fun onStudentItemClicked(student:Student)
    }

}