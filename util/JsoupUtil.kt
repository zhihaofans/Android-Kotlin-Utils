package com.zhihaofans.Android_Kotlin_Utils.util

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

/**
 * Created by zhihaofans on 2017/11/20.
 */
class JsoupUtil(inputDoc: Document) {
    private val doc: Document = inputDoc

    fun img(cssQuery: String): String {
        return this.attr(cssQuery, "src")
    }

    fun attr(cssQuery: String, attrName: String): String {
        val a = doc.select(cssQuery)
        if (a.isNotEmpty()) {
            val attr = a.attr(attrName)
            if (attr.isNotEmpty()) {
                return attr
            }
        }
        return ""
    }

    fun attrOrNull(cssQuery: String, attrName: String): String? {
        val a = doc.select(cssQuery)
        if (a.isNotEmpty()) {
            val attr = a.attr(attrName)
            if (attr.isNotEmpty()) {
                return attr
            }
        }
        return null
    }

    fun title(): String {
        return this.text("head > title")
    }

    fun titleOrNull(): String? {
        return this.textorNull("head > title")
    }

    fun html(cssQuery: String): String {
        val a = doc.select(cssQuery)
        if (a.isNotEmpty()) {
            val html = a.html()
            if (html.isNotEmpty()) {
                return html
            }
        }
        return ""
    }

    fun html(cssQuery: String, index: Int = 0): String {
        val a: Elements = doc.select(cssQuery)
        if (a.isNotEmpty()) {
            if (a.size == 1) return a.html()
            val html = a[index].html()
            if (html.isNotEmpty()) {
                return html
            }
        }
        return ""
    }

    fun htmlorNull(cssQuery: String, index: Int = 0): String? {
        val a = doc.select(cssQuery)
        if (a.isNotEmpty()) {
            if (a.size == 1) return html(cssQuery)
            val html = a[index].html()
            if (html.isNotEmpty()) {
                return html
            }
        }
        return null
    }

    fun textorNull(cssQuery: String): String? {
        val a = doc.select(cssQuery)
        if (a.isNotEmpty()) {
            val text = a.html()
            if (text.isNotEmpty()) {
                return text
            }
        }
        return null
    }

    fun text(cssQuery: String): String {
        val a = doc.select(cssQuery)
        if (a.isNotEmpty()) {
            val text = a.html()
            if (text.isNotEmpty()) {
                return text
            }
        }
        return ""
    }

    fun body(): Elements? {
        val webBody = doc.select("html > body")
        return if (webBody.isEmpty()) {
            null
        } else {
            webBody
        }
    }

    fun link(cssQuery: String): String {
        val link = doc.select(cssQuery)
        return if (link.isEmpty()) {
            ""
        } else {
            link.attr("href") ?: ""
        }
    }

    fun findInElementsText(cssQuery: String, findString: String, matchFull: Boolean = false): List<Element> {
        val findResult = mutableListOf<Element>()
        val elements = doc.select(cssQuery)
        if (elements.size > 0) {
            elements.map {
                if (matchFull) {
                    if (it.text() == findString) findResult.add(it)
                } else {
                    if (it.text().indexOf(findString) != -1) findResult.add(it)
                }

            }

        }
        return findResult
    }

}
