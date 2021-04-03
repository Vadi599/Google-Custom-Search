package com.example.juniortest.search

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.juniortest.R
import com.example.juniortest.adapter.ResultsAdapter
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

    private lateinit var presenter: SearchPresenter
    private lateinit var btnSearch: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var fragmentView: View
    private lateinit var find: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ResultsAdapter
    private lateinit var etEntryField: EditText
    private lateinit var results: MutableList<Results.Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = SearchPresenter(
            this,
            context
        )
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_search, null)
        progressBar = fragmentView.findViewById(R.id.progressBar) as ProgressBar
        find = fragmentView.findViewById(R.id.tvManagedToFind) as TextView
        recyclerView = fragmentView.findViewById(R.id.rvResults) as RecyclerView
        results = ArrayList()
        /* results.add(Results.Item(link = "", displayLink = ""))*/
        adapter = ResultsAdapter(results as ArrayList<Results.Item>)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        etEntryField = fragmentView.findViewById(R.id.etEntryField) as EditText
        btnSearch = fragmentView.findViewById<View>(R.id.btn_start_searching) as Button
        btnSearch.isEnabled = false
        if (isNetworkConnected) {
            presenter.getResultsFromServer()
        } else {
            Toast.makeText(requireContext(), "Нет инета", Toast.LENGTH_SHORT).show();
        }
        btnSearch.setOnClickListener {
            showResults(results as ArrayList<Results.Item>)
            showMessage()
            showVisibility()
        }
        etEntryField.doAfterTextChanged {
            btnSearch.isEnabled = it?.isNotEmpty()!!
        }
        return fragmentView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchingResultsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showResults(results: List<Results.Item>) {
        adapter.setResultsList(results)
        progressBar.visibility = View.GONE
    }

    override fun showMessage() {
        Toast.makeText(requireContext(), "Поиск результатов запроса", Toast.LENGTH_SHORT).show()
    }

    override fun showVisibility() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.VISIBLE
        find.visibility = View.VISIBLE
        btnSearch.visibility = View.GONE
    }

    private val isNetworkConnected: Boolean
        get() {
            val cm =
                requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
        }
}

