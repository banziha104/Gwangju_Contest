package com.nicname.iyeongjun.gwangju_contest.util

import com.google.gson.Gson
import org.json.XML

fun String.getLimitedString( length: Int): String {
    var result = ""
    val arr = this.split("")
    var count = 0
    for (node in arr) {
        if (count < length) {
            if (node == " ")
                count += 1
            else
                count += 2
            result += node
        }
    }
    result += ".."
    return result
}

fun String?.setNull() : String{
    if(this == null){
        return "정보가 없습니다"
    }else{
        return this
    }
}

fun <T> String.xmlToJson(cla : Class<T>) : Class<T>{
    val str = XML.toString(this)
    return Gson().fromJson(str,cla::class.java)
}