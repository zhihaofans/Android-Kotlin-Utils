package com.zhihaofans.Android_Kotlin_Utils.kotlinEx

import android.content.SharedPreferences

/**
 * Created by zhihaofans on 2018/11/4.
 */
fun SharedPreferences.getStringOrNull(key: String): String? = this.getString(key, null)

fun SharedPreferences.getStringSetOrNull(key: String): Set<String>? = this.getStringSet(key, null)
fun SharedPreferences.getBooleanOrFalse(key: String) = this.getBoolean(key, false)
fun SharedPreferences.getIntOrZero(key: String) = this.getInt(key, 0)
