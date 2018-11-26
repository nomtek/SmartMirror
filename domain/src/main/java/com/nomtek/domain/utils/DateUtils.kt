package com.nomtek.domain.utils

import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Damian Kwasniak on 9/21/17.
 */
class DateUtils {

    companion object {

        fun formatDate(milliseconds: Long) /* This is your topStory.getTime()*1000 */: String {
            val sdf = SimpleDateFormat("yyy-MM-dd")
            sdf.timeZone = TimeZone.getTimeZone("Europe/Warsaw")
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds
            val tz = TimeZone.getDefault()
            sdf.timeZone = tz
            return sdf.format(calendar.time)
        }

        fun formatTime(milliseconds: Long) /* This is your topStory.getTime()*1000 */: String {
            val sdf = SimpleDateFormat("HH:mm")
            sdf.timeZone = TimeZone.getTimeZone("Europe/Warsaw")
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds
            return sdf.format(calendar.time)
        }

        fun getDayNameForDate(milliseconds: Long): String {
            val dayFormat = SimpleDateFormat("E", Locale("pl"))
            dayFormat.timeZone = TimeZone.getTimeZone("Europe/Warsaw")
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds
            return dayFormat.format(calendar.time)
        }
    }
}