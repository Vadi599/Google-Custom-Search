package com.example.juniortest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.juniortest.R
import com.example.juniortest.searching_results.SearchingResultsFragment

class MainActivity : AppCompatActivity(), MainContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val btnSearch = findViewById<View>(R.id.btn_start_searching) as Button
        btnSearch.setOnClickListener {
            showSearchingResults()
            showMessage()
        }
    }

    override fun showMessage() {
        Toast.makeText(this@MainActivity,"Поиск результатов запроса", Toast.LENGTH_SHORT).show()
    }

    override fun showSearchingResults() {
         val fragment =
                   SearchingResultsFragment
               val transaction = supportFragmentManager.beginTransaction()
               transaction.add(R.id.container, fragment)
               transaction.addToBackStack(null)
               transaction.commit()
    }
}