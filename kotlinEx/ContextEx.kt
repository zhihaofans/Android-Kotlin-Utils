package com.zhihaofans.Android_Kotlin_Utils.kotlinEx

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import com.orhanobut.logger.Logger
import com.zhihaofans.Android_Kotlin_Utils.R

/**

 * @author: zhihaofans

 * @date: 2018-11-06 15:55

 */
fun Context.appName(): String = this.getString(R.string.app_name)

fun Context.copy(text: String) {
    (this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip = ClipData.newPlainText(this.packageName + ".text", text)
}

fun Context.paste(): String? {
    val clipManager = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    if (clipManager.hasPrimaryClip() || clipManager.primaryClipDescription != null || clipManager.primaryClipDescription!!.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) return null
    val pasteData = clipManager.primaryClip!!.getItemAt(0).text
    if (pasteData.isNullOrEmpty()) return null
    return pasteData.toString()
}

fun Context.logD(message: Any) = Logger.d(message)
fun Context.logE(message: String) = Logger.e(message)
fun Context.logI(message: String) = Logger.i(message)