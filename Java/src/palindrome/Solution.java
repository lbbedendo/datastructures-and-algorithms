package palindrome;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Arara -> " + isPalindrome("Arara"));
        System.out.println("I did, did I ? -> " + isPalindrome("I did, did I ?"));
        System.out.println("Hello -> " + isPalindrome("Hello"));
        System.out.println("Racecar -> " + isPalindrome("Racecar"));
        System.out.println("Leonardo -> " + isPalindrome("Leonardo"));
        System.out.println("Ana -> " + isPalindrome("Ana"));
    }

    public static boolean isPalindrome(String input) {
        var inputLowerCase = input.toLowerCase();
        var stack = new LinkedList<Character>();
        var queue = new LinkedList<Character>();
        for (int i = 0; i < inputLowerCase.length(); i++) {
            char chr = inputLowerCase.charAt(i);
            if (Character.isLetter(chr)) {
                stack.push(chr);
                queue.addLast(chr);
            }
        }

        while (!queue.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }
}