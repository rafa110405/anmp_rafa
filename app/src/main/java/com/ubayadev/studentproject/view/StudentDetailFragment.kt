package com.ubayadev.studentproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubayadev.studentproject.R
import com.ubayadev.studentproject.databinding.ActivityMainBinding
import com.ubayadev.studentproject.databinding.FragmentStudentDetailBinding
import com.ubayadev.studentproject.viewmodel.DetailViewModel
import com.ubayadev.studentproject.viewmodel.ListViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var binding: FragmentStudentDetailBinding
    private lateinit var  viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val student = StudentDetailFragmentArgs.fromBundle(requireArguments()).student

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(student)

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            binding.txtStudentName.setText(it.name)
            binding.txtStudentName.setText(it.id)
            binding.txtStudentName.setText(it.bod)
            binding.txtStudentName.setText(it.phone)
        })
    }
}