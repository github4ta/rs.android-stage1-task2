package subtask4

class Pangram {

    var maxCounts = 0

    fun getResult(inputString: String): String {
        var outString = inputString.trim();
        if (outString.equals("")){
            return ""
        }
        outString = removeSpaces(outString)
        val allAlphabet = isAllAlphabet(outString)
        outString = if(allAlphabet) allVowelsToUppercase(outString) else allConsonantsToUppercase(outString)
        return sortedString(countedWords(outString, allAlphabet))
    }

    private fun removeSpaces(input: String): String {
        return input.replace("\\s{2,}".toRegex(), " ")
    }

    private fun allVowelsToUppercase(str: String): String {
        var outStr = str.replace('a', 'A')
        outStr = outStr.replace('e', 'E')
        outStr = outStr.replace('i', 'I')
        outStr = outStr.replace('o', 'O')
        outStr = outStr.replace('u', 'U')
        outStr = outStr.replace('y', 'Y')
        return outStr
    }

    private fun allConsonantsToUppercase(str: String): String {
        var outStr = str.replace('q', 'Q')
        outStr = outStr.replace('w', 'W')
        outStr = outStr.replace('r', 'R')
        outStr = outStr.replace('t', 'T')
        outStr = outStr.replace('p', 'P')
        outStr = outStr.replace('s', 'S')
        outStr = outStr.replace('d', 'D')
        outStr = outStr.replace('f', 'F')
        outStr = outStr.replace('g', 'G')
        outStr = outStr.replace('h', 'H')
        outStr = outStr.replace('j', 'J')
        outStr = outStr.replace('k', 'K')
        outStr = outStr.replace('l', 'L')
        outStr = outStr.replace('z', 'Z')
        outStr = outStr.replace('x', 'X')
        outStr = outStr.replace('c', 'C')
        outStr = outStr.replace('v', 'V')
        outStr = outStr.replace('b', 'B')
        outStr = outStr.replace('n', 'N')
        outStr = outStr.replace('m', 'M')
        return outStr
    }

    private fun removeOuterSpaces(str: String): String {
        var outStr = ""
        var stringSize = str.length
        var index = 0
        var prefixIndex = -1

        do {
            if (str.get(index).equals(' ')) {
                prefixIndex = index
            } else {
                break
            }
            index +=1
        } while (index < stringSize - 1)

        if (prefixIndex == -1) {
            outStr = str
        } else {
            outStr = str.removeRange(0, prefixIndex + 1)
        }

        stringSize = outStr.length
        index = stringSize - 1
        var postfixIndex = -1
        do {
            if (outStr.get(index).equals(' ')) {
                postfixIndex = index
            } else {
                break
            }
            index -=1
        } while (index >= 0)

        if (postfixIndex != -1) {
            outStr = outStr.removeRange(postfixIndex, stringSize)
        }
        return outStr
    }

    private fun isAllAlphabet(input: String):Boolean {
        var index = 0
        var visited = MutableList<Boolean>(26){ index -> false}

        for (id in 0..input.length-1) {
            if ('a' <= input[id] && input[id] <= 'z') {
                index = input[id] - 'a'
                visited[index] = true
            } else if ('A' <= input[id] && input[id] <= 'Z') {
                index = input[id] - 'A'
                visited[index] = true
            }
        }

        for (id in 0..25) {
            if (!visited[id]) {
                return false;
            }
        }
        return true;
    }

    private fun countVowels(input: String): Int {
        var result = 0
        for (i in 0..input.length - 1) {
            if (isVowel(input.get(i))) {
                result += 1
            }
        }
        if (result > maxCounts) {
            maxCounts = result
        }
        return result
    }

    private fun countConsonants(input: String): Int {
        var result = 0
        for (i in 0..input.length - 1) {
            if (isConsonant(input.get(i))) {
                result += 1
            }
        }
        if (result > maxCounts) {
            maxCounts = result
        }
        return result
    }

    private fun isConsonant(symbol: Char): Boolean {
        if (!isVowel(symbol)) {
            if (symbol in 'a'..'z' || symbol in 'A'..'Z'){
                return true
            }
        }
        return false
    }

    private fun isVowel(symbol: Char): Boolean {
        return symbol == 'a' || symbol == 'A' || symbol == 'e' || symbol == 'E' ||
                symbol == 'i' || symbol == 'I' || symbol == 'o' || symbol == 'O' ||
                symbol == 'u' || symbol == 'U' || symbol == 'y' || symbol == 'Y'
    }

    private fun countedWords(input: String, isAllAlphabet: Boolean): String {
        var words = input.split(" ").toMutableList()
        var count = 0
        var element = ""
        for (i in 0..words.size - 1) {
            if (isAllAlphabet) {
                count = countVowels(words.get(i))
            } else {
                count = countConsonants(words.get(i))
            }
            element = words.get(i)
            words.set(i, count.toString().plus(element))
        }
        return words.joinToString(" ")
    }

    private fun sortedString(input: String): String {
        val words = input.split(" ")
        var sortedWords = mutableListOf<String>()
        for (j in 0..maxCounts) {
            for (i in 0..words.size - 1) {
                if (words.get(i).startsWith(j.toString())) {
                    sortedWords.add(words.get(i))
                }
            }
        }
        return sortedWords.joinToString(" ")
    }
}
