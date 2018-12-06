package com.zhihaofans.Android_Kotlin_Utils.kotlinEx

import android.R.layout
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView

/**
 * Created by zhihaofans on 2018/8/26.
 */
fun ListView.init(context: Context, listData: List<String>) {
    this.adapter = ArrayAdapter<String>(context, layout.simple_list_item_1, listData)
}

fun ListView.removeAllItems() {
    this.adapter = null
}
