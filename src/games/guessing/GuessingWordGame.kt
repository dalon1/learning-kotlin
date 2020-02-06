package games.guessing



data class Word(var originalWord: String, var currentWord: String)

class WordTransform() {
    fun unmask(word: Word, letter: Char): String {
        var tmp = word.currentWord.toCharArray()
        word.originalWord.toCharArray().forEachIndexed { i, c ->  if (c == letter) tmp[i] = letter}
        return String(tmp)
    }
}


// repeat: Native kotlin method - it repeats a string multiple times -- no need to loop
fun String.maskAll() = "*".repeat(this.length)

fun main(args: Array<String>) {

    // 1. Tener la palabra definida
    // 2. Enmascarar la parabra con asteriscos
    // 3. Preguntar el usuario por una letra
    // 4. conseguir todos los indexes de una letra especifica - no requiero eso anymore
    // 5. Comparar la letra con palabra original y remplazar asteriscos a dicha letra.

    var initialWord = "israel"
    var word: Word = Word(initialWord, initialWord.maskAll())

    while (word.currentWord.indexOf("*") != -1) {
        print("Guess word: ${word.currentWord}\nEnter letter: ")
        var myLetter: String = readLine()!!
        word.currentWord = WordTransform().unmask(word, myLetter.single())
    }
    println("${"#".repeat(60)}\nYou won! The answer is ${word.originalWord}\n${"#".repeat(60)}")
}