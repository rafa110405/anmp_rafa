package com.ubayadev.anmp_week1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ubayadev.anmp_week1.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ambil score dari GameFragment
        val score = ResultFragmentArgs.fromBundle(requireArguments()).score

        // tampilkan score
        binding.txtScore.text = "Your score is $score"

        // tombol kembali ke main screen
        binding.btnBackMain.setOnClickListener {
            val action = ResultFragmentDirections.actionHomeFragment()
            it.findNavController().navigate(action)
        }
    }
}