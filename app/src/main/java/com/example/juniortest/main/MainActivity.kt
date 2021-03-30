package com.example.juniortest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.juniortest.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val btnSearch = findViewById<View>(R.id.btn_start_searching) as Button
        btnSearch.setOnClickListener(View.OnClickListener {
            val fragment =
                SearchingResultsFragment
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, fragment as Fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        })*/
    }
}