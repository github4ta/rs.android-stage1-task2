package subtask1

import java.time.DateTimeException
import java.time.LocalDate

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val russianMonths = arrayListOf<String>("января", "февраля", "марта", "апреля", "мая", "июня",
            "июля", "августа", "сентября", "октября", "ноября", "декабря")
        val russianDayOfWeek = arrayListOf<String>("понедельник", "вторник", "среда", "четверг",
            "пятница", "суббота", "воскресенье")

        try {
            val dayOfWeek = LocalDate.of(year.toInt(), month.toInt(), day.toInt()).dayOfWeek.value
            return "${day} ${russianMonths[month.toInt() - 1]}, ${russianDayOfWeek[dayOfWeek - 1]}"
        } catch (e: DateTimeException) {
            return "Такого дня не существует"
        }
    }
}
