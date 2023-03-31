package com.example.nastedrecyclerviewpractice.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parent_table")
data class ParentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val muscle: String,
    val childCount: Int,
    val totalWeight: String,
    val maxKg: String,
    val totalCount: String
)

@Entity(tableName = "child_table")
data class ChildEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val parentId: Int,
    val setNumber: Int,
    val kg: Int,
    val count: Int
)