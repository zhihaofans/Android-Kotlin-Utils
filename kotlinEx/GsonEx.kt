package com.zhihaofans.Android_Kotlin_Utils.kotlinEx

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.zhihaofans.Android_Kotlin_Utils.util.HttpUtil

/**

 * @author: zhihaofans

 * @date: 2018-11-12 19:55

 */

@Throws(JsonSyntaxException::class)
fun <T> Gson.fromWebGetJson(url: String, classOfT: Class<T>): T? {
    val json = HttpUtil.httpGetString(url)
    if (json.isNullOrEmpty()) return null
    return this.fromJson(json, classOfT)
}

@Throws(JsonSyntaxException::class)
fun <T> Gson.fromWebPostJson(url: String, body: MutableMap<String, String>? = null, classOfT: Class<T>): T? {
    val json = HttpUtil.httpPostString(url, body ?: mutableMapOf())
    if (json.isNullOrEmpty()) return null
    return this.fromJson(json, classOfT)
}