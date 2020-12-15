package com.msiazn.kotlinbirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.msiazn.kotlinbirthday.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = generateDummyDataForRecyclerView(500)
        binding.recyclerView.adapter = SingleItemAdapter(dataList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
    }


    private fun generateDummyDataForRecyclerView(requestedSize:Int): List<SingleItem> {
        val list = ArrayList<SingleItem>()
        repeat(requestedSize){
            val drawable = when(it % 5){
                0 -> R.drawable.ic_icon_00
                1 -> R.drawable.ic_icon_01
                2 -> R.drawable.ic_icon_02
                3 -> R.drawable.ic_icon_03
                else -> R.drawable.ic_icon_04
            }
            val item = SingleItem(drawable,"Item $it","Subtitle for item $it")
            list += item
        }
        return list
    }
}