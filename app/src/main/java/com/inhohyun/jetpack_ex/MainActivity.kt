package com.inhohyun.jetpack_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>()

        items.add("a")
        items.add("b")
        items.add("c")

        val rv = findViewById<RecyclerView>(R.id.rv)

        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)


        //어댑터에 생성한 클릭 개체를 가져와서 사용하기
        rvAdapter.itemClick = object : RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position], Toast.LENGTH_LONG).show()
            }

        }

        /*
        * listView vs recyclerView
        * recyclerView는 viewHolder로 view를 재사용하니까 성능이 더 좋음
        * 다만 recyclerView는 itemClick을 따로 구현해줘야해서 번거롭긴함 -> 왜 따로 만들게 만들어놨을까?
        * */


    }
}