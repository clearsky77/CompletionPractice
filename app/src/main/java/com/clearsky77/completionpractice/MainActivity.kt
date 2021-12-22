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
        btnSetOff.setOnClickListener {
            callBackMethod1(completion = {
                Log.d(TAG, "2초 후에 폭발했다!")
                btnSetOff.visibility = View.GONE
                txtView.visibility = View.VISIBLE
                txtMessage.text = it

                callBackMethod2(completion = {
                    txtMessage.text = txtMessage.text.toString()+"\n"+it

                    callBackMethod3(completion = {
                        txtMessage.text = txtMessage.text.toString() + "\n" + it

                        callBackMethod4(completion = {
                            txtMessage.text = txtMessage.text.toString() + "\n" + it

                            callBackMethod5(completion = {
                                txtMessage.text = txtMessage.text.toString() + "\n" + it
                                btnReplay.visibility = View.VISIBLE
                            })

                        })

                    })

                })

            })
        }

        btnReplay.setOnClickListener {
            txtView.visibility = View.GONE
            btnReplay.visibility = View.GONE
            btnSetOff.visibility = View.VISIBLE
            txtMessage.text = ""
        }


    }

    private fun setValues() {
    }

    fun callBackMethod1(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod1()")
        Handler().postDelayed({
            completion("callBackMethod1에서 펑!🎆")
        }, 2000)
    }

    fun callBackMethod2(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod2()")
        Handler().postDelayed({
            completion("    callBackMethod2에서도 펑!\uD83C\uDF86")
        }, 1000)
    }

    fun callBackMethod3(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod3()")
        Handler().postDelayed({
            completion("        callBackMethod3에서도 펑!\uD83C\uDF86")
        }, 1000)
    }

    fun callBackMethod4(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod4()")
        Handler().postDelayed({
            completion("            callBackMethod4에서도 펑!\uD83C\uDF86")
        }, 1000)
    }

    fun callBackMethod5(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod5()")
        Handler().postDelayed({
            completion("                callBackMethod5에서도 펑!\uD83C\uDF86 \n 콜백 헬이 완성 되었다 -_-)v")
        }, 1000)
    }
}