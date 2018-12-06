package com.zhihaofans.Android_Kotlin_Utils.kotlinEx

import android.webkit.URLUtil
import java.net.URI
import java.net.URL

/**
 * Created by zhihaofans on 2018/9/15.
 */

// String
fun String.find(string: String, startIndex: Int = 0, ignoreCase: Boolean = false): Int = this.indexOf(string, startIndex, ignoreCase)

fun String.remove(removeString: String, ignoreCase: Boolean = false) = this.replace(removeString, "", ignoreCase)


// String?
fun String?.isNotNull() = this != null

fun String?.isNotNullAndEmpty() = !this.isNullOrEmpty()
fun String?.isUrl(): Boolean {
    if (this.isNullOrEmpty()) return false
    return try {
        URLUtil.isValidUrl(this)
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

fun String?.toUrl(): URL? = URL(this)
fun String?.toURI(): URI? = URI(this)