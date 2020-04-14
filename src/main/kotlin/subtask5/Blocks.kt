package subtask5

import java.time.LocalDate
import java.time.format.DateTimeParseException
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        var blockC = mutableListOf<Any>()
        if (blockA.size <= 0) {
            throw NotImplementedError("Array is empty")
        }

        for (i in 0..blockA.size - 1) {
            if (blockB.isInstance(blockA[i])) {
                blockC.add(blockA[i])
            }
        }

        if (blockB.equals(Int::class)) {
            return blockC.sumBy { it.toString().toInt() }
        }

        if (blockB.equals(String::class)) {
            return blockC.joinToString("") { it.toString() }

        }

        if (blockB.equals(LocalDate::class)) {
            var blockC2 = mutableListOf<LocalDate>()
            for (i in 0..blockC.size - 1) {
                var date = blockC.get(i).toString()
                try {
                    blockC2.add(LocalDate.parse(date))
                } catch (e: DateTimeParseException){
                    throw NotImplementedError("Date is not correct")
                }
            }
            val maxDate = blockC2.max()
            return "${maxDate?.dayOfMonth}.${maxDate?.monthValue}.${maxDate?.year}"
        }

        return throw NotImplementedError("KClass<> is not Int or String, or LocalDate")
    }
}