package com.zhihaofans.androidbox.kotlinEx

/**
 * Created by zhihaofans on 2018/11/4.
 */
fun Boolean.string(trueString: String, falseString: String): String = if (this) trueString else falseString

fun Boolean?.isFalseOrNull(): Boolean = this != true
