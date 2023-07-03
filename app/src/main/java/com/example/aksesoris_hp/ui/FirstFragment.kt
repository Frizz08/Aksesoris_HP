package com.example.aksesoris_hp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aksesoris_hp.R
import com.example.aksesoris_hp.application.AccessorisApp
import com.example.aksesoris_hp.databinding.FragmentFirstBinding
import com.example.aksesoris_hp.model.accessoris
import com.example.aksesoris_hp.repository.aksesorisRepository

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val accessorisViewModel: accessorisViewModel by viewModels{
        AccessorisViewModelFactory((applicationContext as AccessorisApp).repository)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext=requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter=accessorisListAdapter{accessoris ->
            val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment(accessoris)
            findNavController().navigate(action)
        }
        binding.dataRecycleView.adapter=adapter
        binding.dataRecycleView.layoutManager=LinearLayoutManager(context)
        accessorisViewModel.allAccessoris.observe(viewLifecycleOwner){accessoris ->
            accessoris.let {
                if (accessoris.isEmpty()){
                    binding.emptyTextVview.visibility=View.VISIBLE
                    binding.illustrationImageView.visibility=View.VISIBLE
                }else{
                    binding.emptyTextVview.visibility=View.GONE
                    binding.illustrationImageView.visibility=View.GONE
                }
                adapter.submitList(accessoris)
            }
        }

        binding.addFAB.setOnClickListener {
                val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment(null)
                findNavController().navigate(action)
        }
        binding.addFAB.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(null)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}