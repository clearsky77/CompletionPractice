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
            callBackMethod1(completion = {
                Log.d(TAG, "2초 후에 폭발했다!")
                txtView.visibility = View.VISIBLE
                txtMessage.text = it
            })
        }



    }

    private fun setValues() {
    }

    fun callBackMethod1(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod()")

        Handler().postDelayed({
            completion("callBackMethod1에서 폭발했다.")
        }, 2000)
    }
}