package com.ubayadev.studentproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ubayadev.studentproject.databinding.StudentCardItemBinding
import com.ubayadev.studentproject.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>)
    : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        val binding = StudentCardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int
    ) {
        val student = studentList[position]

        holder.binding.txtNRP.text = studentList[position].id
        holder.binding.txtName.text = studentList[position].name
        holder.binding.btnDetail.setOnClickListener {
            val student = studentList[position]
            val action = StudentListFragmentDirections.actionStudentDetailFragment(student)
            it.findNavController().navigate(action)
        }
    }

    fun updateStudentList (newStudentList: ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }


    override fun getItemCount() = studentList.size

    class StudentViewHolder(var binding: StudentCardItemBinding)
        : RecyclerView.ViewHolder(binding.root)
}
