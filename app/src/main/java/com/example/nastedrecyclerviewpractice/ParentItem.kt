package com.example.nastedrecyclerviewpractice

data class ParentItem(
    val exerciseName: String,
    val exerciseType: String,
    var totalSet: Int,
    var totalKG: String,
    var bestKg: String,
    var totalCount: String,
    val mList: List<ChildItem>)
