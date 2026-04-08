package com.ubayadev.studentproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubayadev.studentproject.R
import com.ubayadev.studentproject.databinding.ActivityMainBinding
import com.ubayadev.studentproject.databinding.FragmentStudentListBinding
import com.ubayadev.studentproject.viewmodel.ListViewModel

class StudentListFragment : Fragment() {
    private lateinit var binding: FragmentStudentListBinding
    private val adapter = StudentListAdapter(arrayListOf())
    private lateinit var  viewModel: ListViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.recViewStudent.layoutManager = LinearLayoutManager(context)
        binding.recViewStudent.adapter = adapter

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            adapter.updateStudentList(it)
            binding.swipeRefresh.isRefreshing = false
        })

        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer{
            if(it)
                binding.txtError.visibility = View.VISIBLE
            else
                binding.txtError.visibility = View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.progressLoad.visibility = View.VISIBLE
            else
                binding.progressLoad.visibility = View.GONE
        })
    }

}