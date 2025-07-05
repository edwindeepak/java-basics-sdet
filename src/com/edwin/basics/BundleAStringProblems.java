import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BundleAStringProblems {

    public static void main(String[] args) {
        // Uncomment one test case at a time to run specific problems:

        // Problem 1: Reverse String
        // System.out.println("Reversed: " + reverseString("kovaidotco is it"));

        // Problem 2: Palindrome Check
        // System.out.println("Is Palindrome? " + palindromeCheck("A man, a plan, a canal: Panama"));

        // Problem 3: Remove Duplicates
        // System.out.println("Without Duplicates: " + removeDuplicates("programming"));

        // Problem 4: Character Frequency
        // characterFrequency("programming");

        // Problem 5: Check Anagram
        // String s1 = "Listen";
        // String s2 = "Silent";
        // System.out.println("Strings: " + s1 + ", " + s2);
        // isAnagram(s1, s2);
    }

    // ------------------------------------------------
    // Problem 1: Reverse a String
    // ------------------------------------------------
    public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }

    // ------------------------------------------------
    // Problem 2: Palindrome Check (ignores case/spaces/punctuation)
    // ------------------------------------------------
    public static boolean palindromeCheck(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);

            if (!Character.isLetterOrDigit(left)) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(right)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // ------------------------------------------------
    // Problem 3: Remove Duplicate Characters from String
    // ------------------------------------------------
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // ------------------------------------------------
    // Problem 4: Character Frequency Count
    // ------------------------------------------------
    public static void characterFrequency(String s) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }
        System.out.println();
    }

    // ------------------------------------------------
    // Problem 5: Check if Two Strings Are Anagrams
    // ------------------------------------------------
    public static void isAnagram(String a, String b) {
        a = a.replaceAll("\\s", "").toLowerCase();
        b = b.replaceAll("\\s", "").toLowerCase();

        if (a.length() != b.length()) {
            System.out.println("Not an anagram");
            return;
        }

        int[] alphabets = new int[26];

        for (int i = 0; i < a.length(); i++) {
            alphabets[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            alphabets[b.charAt(i) - 'a']--;
        }

        for (int count : alphabets) {
            if (count != 0) {
                System.out.println("Not an anagram");
                return;
            }
        }

        System.out.println("Is an anagram");
    }
}
