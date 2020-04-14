package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(inputNumber: Int): IntArray {
        if (inputNumber < 0) {
            throw NotImplementedError("Not valid input number") as Throwable
        }
        if (inputNumber == 0) {
            return intArrayOf(0, 1, 1);
        }

        var fibonacciNumbers = mutableListOf<Int>(0, 1)
        var index = 1
        var prod : Int

        do {
            fibonacciNumbers.add(fibonacciNumbers.get(index) + fibonacciNumbers.get(index-1));
            index += 1;
            prod = fibonacciNumbers.get(index) * fibonacciNumbers.get(index-1)
            if (prod == inputNumber) {
                return intArrayOf(fibonacciNumbers.get(index - 1), fibonacciNumbers.get(index), 1)
            }
        } while (prod < inputNumber)

        return intArrayOf(fibonacciNumbers.get(index - 1), fibonacciNumbers.get(index), 0);
    }
}
