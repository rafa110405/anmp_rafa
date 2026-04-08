package com.ubayadev.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ubayadev.anmp_week1.databinding.ActivityMainBinding
import com.ubayadev.anmp_week1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStart.setOnClickListener {
            val player_name =  binding.txtName.text.toString()

            val actionGame = MainFragmentDirections.actionGameFragment(player_name)
            it.findNavController().navigate(actionGame)
        }

        binding.btnOption.setOnClickListener {
            val actionOption = MainFragmentDirections.actionOptionFragment()
            it.findNavController().navigate(actionOption)
        }
    }
}