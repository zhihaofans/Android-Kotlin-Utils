package com.zhihaofans.Android_Kotlin_Utils.util

import android.content.ClipData
import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE


/**

 * @author: zhihaofans

 * @date: 2018-11-06 13:49

 */
class ClipboardUtil(context: Context) {
    private val mContext = context
    private val clipManager = mContext.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    private fun isEnabled(mimeType: String): Boolean {
        return clipManager.hasPrimaryClip() || clipManager.primaryClipDescription != null || clipManager.primaryClipDescription!!.hasMimeType(mimeType)
    }

    fun copy(text: String) {
        clipManager.primaryClip = ClipData.newPlainText(mContext.packageName + ".text", text)
    }

    fun paste(): String? {
        if (this.isEnabled(MIMETYPE_TEXT_PLAIN)) return null
        val pasteData = clipManager.primaryClip!!.getItemAt(0).text
        if (pasteData.isNullOrEmpty()) return null
        return pasteData.toString()
    }

}