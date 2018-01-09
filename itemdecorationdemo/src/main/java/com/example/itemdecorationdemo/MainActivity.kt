package com.example.itemdecorationdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var data = arrayListOf<CityBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repeat(10) {
            var city =CityBean("111","222")
            data.add(city)
        }
        repeat(10) {
            var city =CityBean("111","3333")
            data.add(city)
        }
        rv_item_decoration.addItemDecoration(TitleItemDecoration(this,data))
        rv_item_decoration.layoutManager = LinearLayoutManager(this)
        rv_item_decoration.adapter = ItemDecorationAdapter(data)
    }
}
