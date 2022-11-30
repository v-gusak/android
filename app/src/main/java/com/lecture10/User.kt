package com.lecture10

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey (autoGenerate = true) val uid: Int = 0,
    @ColumnInfo (name = "name") val name: String?,
    @ColumnInfo (name = "age") val age: Int
)
