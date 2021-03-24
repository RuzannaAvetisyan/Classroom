package com.example.classroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity(), StudentsListFragment.StudentListFragmentListener, CreateStudentFragment.CreateStudentFragmentListener {

    private val studentsListFragment = StudentsListFragment()
    private var studentInfoFragment = StudentInfoFragment()
    private lateinit var createStudentFragment: CreateStudentFragment
    private lateinit var createGradeFragment: CreateGradeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        studentsListFragment.listener = this
        supportFragmentManager.beginTransaction().add(R.id.container, studentsListFragment).commit()
    }

    override fun onCreateStudentButtonClicked() {
        createStudentFragment = CreateStudentFragment()
        createStudentFragment.listener = this
        createStudentFragment.show(supportFragmentManager, "CreateUserFragment")
    }

    override fun onStudentItemClicked(student: Student) {
        studentInfoFragment.student = student
        studentInfoFragment.listener = object : StudentInfoFragment.StudentInfoFragmentListener {
            override fun onCreateGradeButtonClicked() {

                createGradeFragment = CreateGradeFragment()
                createGradeFragment.listener = object : CreateGradeFragment.CreateGradeFragmentListener {
                    override fun onGradeCreated(grade: Grade) {
                        createGradeFragment.dismiss()
                        student.grades.add(grade)
                        studentInfoFragment.notifyDataChanged()
                    }

                }
                createGradeFragment.show(supportFragmentManager, "CreateUserFragment")
            }

        }
        supportFragmentManager.beginTransaction().replace(R.id.container, studentInfoFragment).commit()
    }

    override fun onStudentCreated(student: Student) {
        createStudentFragment.dismiss()
        students.add(student)
        studentsListFragment.notifyDataChanged()
    }
}