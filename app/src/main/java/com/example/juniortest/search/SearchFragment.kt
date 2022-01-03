package com.example.juniortest.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.juniortest.adapter.ResultsAdapter
import com.example.juniortest.databinding.FragmentSearchBinding
import com.example.juniortest.model.Results


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
        binding.run {
            rvResults.adapter = adapter
            btnStartSearching.isEnabled = false
            btnClear.setOnClickListener {
                etEntryField.setText("")
            }
            btnStartSearching.setOnClickListener {
                val enteredText = etEntryField.text.toString()
                presenter.getResultsFromServer(enteredText)
            }
            etEntryField.doAfterTextChanged {
                btnStartSearching.isEnabled = it?.isNotEmpty()!!
                if (etEntryField.text.toString() == "") {
                    rvResults.visibility = View.GONE
                    tvManagedToFind.visibility = View.GONE
                    btnStartSearching.visibility = View.VISIBLE
                    btnClear.visibility = View.GONE
                } else {
                    btnClear.visibility = View.VISIBLE
                }
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
    }

    override fun showMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showVisibility() {
        binding.run {
            rvResults.visibility = View.VISIBLE
            tvManagedToFind.visibility = View.VISIBLE
            btnStartSearching.visibility = View.GONE
        }
    }

    override fun showLoading(show: Boolean) {
        binding.progressBar.isVisible = show
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

