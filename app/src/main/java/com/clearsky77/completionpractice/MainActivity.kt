package com.clearsky77.completionpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()


    }

    private fun setupEvents() {
        btnExplosion.setOnClickListener {
            callBackMethod()
        }
    }

    private fun setValues() {
    }

    fun callBackMethod(){
        Log.d(TAG, "callBackMaethod()")

        Handler().postDelayed({
            Log.d(TAG, "3초 후에 폭발")
            txtView.visibility = View.VISIBLE
        }, 3000)
    }
}