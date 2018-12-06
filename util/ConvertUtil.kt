package com.zhihaofans.Android_Kotlin_Utils.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.orhanobut.logger.Logger
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by zhihaofans on 2018/7/23.
 */
class ConvertUtil {
    @SuppressLint("SimpleDateFormat")
    fun githubUtc2Local(utcTime: String): String {
        var githubUtc = utcTime
        githubUtc = githubUtc.replace("T", " ")
        githubUtc = githubUtc.replace("Z", " ")
        Logger.d("githubUtc:$githubUtc")
        val utcFormater = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")//UTC时间格式
        utcFormater.timeZone = TimeZone.getTimeZone("UTC")
        var gpsUTCDate: Date? = null
        try {
            gpsUTCDate = utcFormater.parse(githubUtc)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val localFormater = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")//当地时间格式
        localFormater.timeZone = TimeZone.getDefault()
        return localFormater.format(gpsUTCDate!!.time)
    }

    fun unixTime2date(time: Int): String {
        return unixTime2date(time.toLong())
    }

    fun unixTime2date(time: Long): String {
        Logger.d(time)
        return SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA).format(Date(time)) as String
    }

    fun drawable2bitmap(context: Context, src: Int): Bitmap? {
        return BitmapFactory.decodeResource(context.resources, src)
    }

    fun boolean2string(boolean: Boolean): String {
        return boolean.toString()
    }

    fun boolean2string(boolean: Boolean, trueString: String, falseString: String): String {
        return if (boolean) {
            trueString
        } else {
            falseString
        }
    }

    fun fileSizeInt2string(fileSize: Long): String = this.fileSizeInt2string(fileSize.toInt())
    fun fileSizeInt2string(fileSize: Int): String {
        var result = fileSize.toFloat()
        var times = 0
        while (result >= 1024) {
            result /= 1024
            times++
        }
        val units = mutableListOf("B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB", "BB", "NB", "DB", "CB")
        val sizeUnit = if (times >= units.size) "???" else units[times]
        return "$result $sizeUnit"
    }

    fun json2List(jsonData: String): List<Any> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Any>>() {}.type
        return gson.fromJson(jsonData, type)
    }


}