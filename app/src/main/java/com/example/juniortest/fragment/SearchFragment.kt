package com.example.juniortest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.example.juniortest.adapter.ResultsAdapter
import com.example.juniortest.databinding.FragmentSearchBinding
import com.example.juniortest.model.Item
import com.example.juniortest.presentation.SearchPresenter
import com.example.juniortest.presentation.SearchView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SearchFragment : MvpAppCompatFragment(), SearchView {

    private lateinit var binding: FragmentSearchBinding

    lateinit var adapter: ResultsAdapter

    private lateinit var results: List<Item?>

    private val presenter by moxyPresenter { SearchPresenter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(
            inflater, container, false
        )
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

    override fun showResults(results: List<Item?>) {
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
}

