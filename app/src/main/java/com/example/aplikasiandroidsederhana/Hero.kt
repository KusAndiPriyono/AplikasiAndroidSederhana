package com.example.aplikasiandroidsederhana

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val element: String,
    val build: String,
    val skill: String,
    val description: String,
    val image: Int
) : Parcelable
