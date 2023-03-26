package com.example.nastedrecyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nastedrecyclerviewpractice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val parentList = ArrayList<ParentItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recordRV.setHasFixedSize(true)
        binding.recordRV.layoutManager = LinearLayoutManager(this)

        addDataToList()
        val adapter = ParentAdapter(parentList)
        binding.recordRV.adapter = adapter
    }

    private fun addDataToList() {

        val childItems1 = ArrayList<ChildItem>()
        childItems1.add(ChildItem(1, 20, 20))
        childItems1.add(ChildItem(2, 30, 15))
        childItems1.add(ChildItem(3, 40, 10))
        childItems1.add(ChildItem(4, 20, 20))
        parentList.add(
            ParentItem(
                "벤치프레스",
                "가슴",
                childItems1.size,
                getTotalWeight(childItems1).toString(),
                getMaxKg(childItems1).toString(),
                getTotalCount(childItems1).toString(),
                childItems1
            )
        )

        val childItems2 = ArrayList<ChildItem>()
        childItems2.add(ChildItem(1, 20, 20))
        childItems2.add(ChildItem(2, 30, 15))
        childItems2.add(ChildItem(3, 40, 10))
        parentList.add(
            ParentItem(
                "딥스",
                "가슴",
                childItems2.size,
                getTotalWeight(childItems2).toString(),
                getMaxKg(childItems2).toString(),
                getTotalCount(childItems2).toString(),
                childItems2
            )
        )
        val childItems3 = ArrayList<ChildItem>()
        childItems3.add(ChildItem(1, 20, 20))
        childItems3.add(ChildItem(2, 18, 15))
        childItems3.add(ChildItem(3, 15, 10))
        childItems3.add(ChildItem(4, 20, 20))
        childItems3.add(ChildItem(5, 20, 20))
        parentList.add(
            ParentItem(
                "덤벨프레스",
                "가슴",
                childItems3.size,
                getTotalWeight(childItems3).toString(),
                getMaxKg(childItems3).toString(),
                getTotalCount(childItems3).toString(),
                childItems3
            )
        )


    }

    fun getTotalWeight(childItems: ArrayList<ChildItem>): Int {
        var totalWeight = 0

        for (item in childItems) {
            totalWeight += item.kg
        }

        return totalWeight
    }

    fun getTotalCount(childItems: ArrayList<ChildItem>): Int {
        var totalCount = 0

        for (item in childItems) {
            totalCount += item.count
        }

        return totalCount
    }

    fun getMaxKg(childItems: ArrayList<ChildItem>): Int? {
        var maxKg: Int? = null

        for (item in childItems) {
            if (maxKg == null || item.kg > maxKg) {
                maxKg = item.kg
            }
        }

        return maxKg
    }
}