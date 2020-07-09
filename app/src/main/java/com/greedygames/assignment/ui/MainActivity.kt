package com.greedygames.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.greedygames.assignment.R
import com.greedygames.assignment.ui.main.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentTransaction(MainFragment(), "")
    }

     fun fragmentTransaction(fragment: Fragment,tag: String){
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .addToBackStack(tag)
            .commit()
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
