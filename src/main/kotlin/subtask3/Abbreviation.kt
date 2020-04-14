package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        if(a.length < b.length) {
            return "NO"
        }

        var matched = mutableListOf<Char>()
        val aUppercase = a.toUpperCase()
        var matcher: Char = b[0]
        var index = 0

        for (i in 0..aUppercase.length-1) {
            if (matcher == aUppercase[i]) {
                matched.add(matcher)
                index +=1
                if(index >= b.length) {
                    break
                } else {
                    matcher = b[index]
                }
            }
        }

        val matchedString = matched.joinToString("")

        if (b.equals(matchedString)) {
            return "YES"
        }
        return "NO";
    }
}
