package subtask2

import java.time.DateTimeException
import java.time.LocalTime

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val digits = arrayListOf<String>("one", "two", "three", "four", "five", "six", "seven", "eight",  "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine")

        try {
            val time = LocalTime.of(hour.toInt(), minute.toInt())
            when (minute.toInt()) {
                0 -> return "${digits[hour.toInt() - 1]} o' clock"
                15 -> return "quarter past ${digits[hour.toInt() - 1]}"
                30 -> return "half past ${digits[hour.toInt() - 1]}"
                45 -> return "quarter to ${digits[hour.toInt()]}"
                in 1..29 -> return "${digits[minute.toInt() - 1]} minutes past ${digits[hour.toInt() - 1]}"
                else -> return "${digits[59 - minute.toInt()]} minutes to ${digits[hour.toInt()]}"
            }
        } catch (e: DateTimeException) {
            return ""
        }
    }
}
