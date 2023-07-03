package com.example.aksesoris_hp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aksesoris_hp.R
import com.example.aksesoris_hp.application.AccessorisApp
import com.example.aksesoris_hp.databinding.FragmentSecondBinding
import com.example.aksesoris_hp.model.accessoris

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

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

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name=binding.namaEditTextText.text
        val address=binding.alamatEditTextText2.text
        binding.saveButton.setOnClickListener {
            val accessoris=accessoris(0, name.toString(), address.toString())
            accessorisViewModel.insert(accessoris)
            findNavController().popBackStack() //untuk dismiss halaman ini
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}