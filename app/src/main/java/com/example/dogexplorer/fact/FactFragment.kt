package com.example.dogexplorer.fact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dogexplorer.databinding.FragmentFactBinding
import com.example.dogexplorer.fact.viewmodel.FactViewModel

class FactFragment : Fragment() {
    private var _binding: FragmentFactBinding? = null
    private val binding get() = _binding!!

    private lateinit var factViewModel: FactViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFactBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        setObservers()

        binding.dogFactBtn.setOnClickListener {
            makeApiCall()
        }

    }


    private fun initViewModel() {
        factViewModel = ViewModelProvider(this).get(FactViewModel::class.java)
    }

    private fun setObservers(){
        factViewModel.getLiveDataObserver().observe(viewLifecycleOwner) { response ->
            if (response != null) {
                binding.dogFactTextView.text = response.text
            } else {
                Log.d("response", "error getting the data")

            }
        }
    }

    private fun makeApiCall() {
        factViewModel.getDogFact()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}