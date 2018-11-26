package com.nomtek.avonil.smartmirror.widgets

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale
import java.util.TimeZone

class HourTextClock : android.widget.TextClock {

    constructor(context: Context) : super(context) {
        setLocaleDateFormat()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setLocaleDateFormat()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        setLocaleDateFormat()
    }

    private fun setLocaleDateFormat() {
        timeZone = "Europe/Warsaw"
        val currentLocale = Locale("pl")
        this.format12Hour = "HH:mm"
    }
}