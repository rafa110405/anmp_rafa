package com.ubayadev.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ubayadev.anmp_week1.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    private var a = 0
    private var b = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun randomNumber(){
        a = (1..20).random()
        b = (1..20).random()

        binding.txtQuestion.text = "$a + $b"
        binding.txtAnswer.setText("")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
        binding.txtTurn.text = "$playerName's Turn"

        // tampilkan soal pertama
        randomNumber()

        // tombol submit
        binding.btnSubmit.setOnClickListener {

            val answer = binding.txtAnswer.text.toString().toIntOrNull()

            if(answer == a + b){
                score++
                randomNumber()
            }
            else{
                val action = GameFragmentDirections
                    .actionResultFragment(score)

                it.findNavController().navigate(action)
            }
        }

        // tombol back
        binding.btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            it.findNavController().navigate(action)
        }
    }
}