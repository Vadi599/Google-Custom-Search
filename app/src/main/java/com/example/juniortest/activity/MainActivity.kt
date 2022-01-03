package com.example.juniortest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.juniortest.R
import com.example.juniortest.SearchApplication
import com.example.juniortest.databinding.ActivityMainBinding
import com.example.juniortest.fragment.SearchFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var fragment: SearchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as SearchApplication).appComponent.injectMainActivity(this)
        binding.layoutToolbar.toolbar
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_dialog_question)
            .setTitle(R.string.exit_from_application)
            .setMessage(R.string.do_you_want_to_exit)
            .setPositiveButton(
                R.string.yes
            ) { dialog, which -> finish() }
            .setNegativeButton(R.string.no, null).show()
    }
}

