package com.wqd.rxhttp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.wqd.rxhttp.APi.Companion.apiService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * @author paranoia
 */
class MainActivity : AppCompatActivity() {


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.setOnClickListener {
            getData()
        }
    }

    @SuppressLint("CheckResult")
    private fun getData() {
        val params = HashMap<String, String>()
        params.put("key", "cc4925365ae4c389f8cc515320a440f0")
        params.put("client", "android")
        http(apiService.getHomePage(params),{
            Log.d("Paranoia",it.result.hasmore.toString())
        })
    }

}
