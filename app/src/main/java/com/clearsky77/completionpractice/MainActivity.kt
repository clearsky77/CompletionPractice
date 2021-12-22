package com.clearsky77.completionpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"
    var millisec = 0L

    var imm: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 입력받는 방법을 관리하는 Manager객체를  요청하여 InputMethodmanager에 반환한다.
        imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?

        setupEvents()
        setValues()


    }

    private fun setupEvents() {
        btnSetOff.setOnClickListener {

            imm?.hideSoftInputFromWindow(btnSetOff.getWindowToken(), 0) // 키보드를 사라지게 함

            millisec = (edtSec.text.toString().toInt() * 1000).toLong()

            callBackMethod1(completion = {
                Log.d(TAG, "2초 후에 폭발했다!")
                laySetOffSetting.visibility = View.GONE
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
            laySetOffSetting.visibility = View.VISIBLE
            txtMessage.text = ""
        }


    }

    private fun setValues() {
    }

    fun callBackMethod1(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod1()")
        Handler().postDelayed({
            Log.d(TAG, "callBackMaethod1() 펑! -----")
            completion("callBackMethod1에서 펑!🎆")
        }, millisec)
    }

    fun callBackMethod2(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod2()")
        Handler().postDelayed({
            Log.d(TAG, "callBackMaethod2() 펑! -----")
            completion("    callBackMethod2에서도 펑!\uD83C\uDF86")
        }, millisec)
    }

    fun callBackMethod3(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod3()")
        Handler().postDelayed({
            Log.d(TAG, "callBackMaethod3() 펑! -----")
            completion("        callBackMethod3에서도 펑!\uD83C\uDF86")
        }, millisec)
    }

    fun callBackMethod4(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod4()")
        Handler().postDelayed({
            Log.d(TAG, "callBackMaethod4() 펑! -----")
            completion("            callBackMethod4에서도 펑!\uD83C\uDF86")
        }, millisec)
    }

    fun callBackMethod5(completion: (String) -> Unit){
        Log.d(TAG, "callBackMaethod5()")
        Handler().postDelayed({
        Log.d(TAG, "callBackMaethod5() 펑! -----")
            completion("                callBackMethod5에서도 펑!\uD83C\uDF86 \n 콜백 헬이 완성 되었다 -_-)v")
        }, millisec)
    }
}