package palindrome

import java.util.*

fun main() {
    println("Arara -> " + isPalindrome("Arara"))
    println("I did, did I ? -> " + isPalindrome("I did, did I ?"))
    println("Hello -> " + isPalindrome("Hello"))
    println("Racecar -> " + isPalindrome("Racecar"))
    println("Leonardo -> " + isPalindrome("Leonardo"))
    println("Ana -> " + isPalindrome("Ana"))

}

fun isPalindrome(input: String): Boolean {
    val stack = LinkedList<Char>()
    val queue = LinkedList<Char>()
    input
        .toLowerCase()
        .filter { it.isLetter() }
        .map {
            stack.push(it)
            queue.addLast(it)
        }

    while (queue.isNotEmpty()) {
        if (stack.pop() != queue.poll()) {
            return false
        }
    }
    return true
}