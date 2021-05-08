package com.example.juniortest.search

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juniortest.adapter.ResultsAdapter
import com.example.juniortest.databinding.FragmentSearchBinding
import com.example.juniortest.model.ResultSearchState
import com.example.juniortest.model.Results
import com.example.juniortest.network.ApiService
import com.example.juniortest.network.ServiceGenerator.apiService
import io.reactivex.Single


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchingResultsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment(), SearchContract.View {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: SearchPresenter
    private lateinit var adapter: ResultsAdapter
    private lateinit var results: List<Results.Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(
            inflater, container, false
        )
        presenter = SearchPresenter(this, requireContext())
        // Inflate the layout for this fragment
        val view = binding.root
        results = ArrayList()
        adapter = ResultsAdapter(results)
        binding.rvResults.adapter = adapter
        binding.btnStartSearching.isEnabled = false
        binding.btnClear.setOnClickListener {
            binding.etEntryField.setText("")
        }
        binding.btnStartSearching.setOnClickListener {
            val enteredText = binding.etEntryField.text.toString()
            presenter.getResultsFromServer(enteredText)
        }
        binding.etEntryField.doAfterTextChanged {
            binding.btnStartSearching.isEnabled = it?.isNotEmpty()!!
            if (binding.etEntryField.text.toString() == "") {
                binding.rvResults.visibility = View.GONE
                binding.tvManagedToFind.visibility = View.GONE
                binding.btnStartSearching.visibility = View.VISIBLE
                binding.btnClear.visibility = View.GONE
            } else {
                binding.btnClear.visibility = View.VISIBLE
            }
        }
        return view
    }

    /*companion object {
        */
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchingResultsFragment.
     *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/

    override fun showResults(results: List<Results.Item>) {
        adapter.setResultsList(results)
        binding.progressBar.visibility = View.GONE
    }

    override fun showMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


    override fun showVisibility() {
        binding.rvResults.visibility = View.VISIBLE
        binding.tvManagedToFind.visibility = View.VISIBLE
        binding.btnStartSearching.visibility = View.GONE
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

