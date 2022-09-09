package com.example.coffeeshop.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeItem(val image:Int,val name:String):Parcelable
