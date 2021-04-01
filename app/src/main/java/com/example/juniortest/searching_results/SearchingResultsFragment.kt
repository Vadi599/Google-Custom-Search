package com.example.juniortest.searching_results

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.juniortest.R
import com.example.juniortest.adapter.ResultsAdapter
import com.example.juniortest.main.MainContract
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
class SearchingResultsFragment : Fragment(), SearchingResultsContract.View {
    private lateinit var progressBar: ProgressBar
    private lateinit var fragmentView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ResultsAdapter
    private lateinit var results: MutableList<Results.Item>
    private lateinit var presenter: SearchingResultsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = SearchingResultsPresenter(
            this,
            context
        )
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_searching_results, null)
        results = ArrayList()
        presenter.getResultsFromServer()
        progressBar = fragmentView.findViewById(R.id.progressView) as ProgressBar
        recyclerView = fragmentView.findViewById<View>(R.id.rvResults) as RecyclerView
        adapter = ResultsAdapter(results)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
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
            SearchingResultsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSearchingResults(results: List<Results.Item>) {
        adapter.setResultsList(results)
        progressBar.visibility = View.GONE
    }
}