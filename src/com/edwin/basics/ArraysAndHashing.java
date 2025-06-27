import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraysAndHashing {

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 4,3};
        // String s = "ramu";
        // String t = "aomu";
        // System.out.println(isAnagram(s, t));
        // System.out.println(containsDuplicates(nums));
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] twosumresult = twoSum(nums, target);
        for (int i : twosumresult) {
            System.out.println(i);
        }
    }

    public static boolean containsDuplicates(int[] nums) {

        // Approach 1
        /*
         * int dups = 0;
         * if (dups >= 1) {
         * break;
         * } else if (nums[i] == nums[i - 1]) {
         * dups += 1;
         * }
         * }
         * if (dups > 0) {
         * return true;
         * } else {
         * return false;
         * } for (int i = 1; i < nums.length; i++) {
         */
        // Approach2
        /*
         * Set<Integer> numSet =
         * Arrays.stream(nums).boxed().collect(Collectors.toSet());
         * 
         * if(nums.length != numSet.size()){
         * return false;
         * }
         * else{
         * return true;
         * }
         */
        // Approach 3 --- Better
        /*
         * Imagine a guest List (HashSet) at a party
         * As each person (number) arrives
         * If they are already on the list, its a duplicate so return true
         * If not add them to the list.
         * If everyone is unique, return false at the end
         */
        Set<Integer> numset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (numset.contains(nums[i])) {
                return true;
            }
            numset.add(nums[i]);
        }
        return false;
    }

    public static boolean isAnagram(String s, String t) {

        // Approach 1

        /*
         * if(s.length() != t.length()){
         * return false;
         * }
         * char[] sarr = s.toCharArray();
         * char[] tarr = t.toCharArray();
         * Arrays.sort(sarr);
         * Arrays.sort(tarr);
         * return(Arrays.equals(sarr, tarr));
         */

        // Approach2
        /*
         * Use an array of 26 buckets to count letters,
         * Increment counts for each letter in first String
         * Decrement for each letter in second String one by one
         * If any count goes below while decrement, return false immediately
         * If all balances out return true
         */

        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--alphabets[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (numMap.containsKey(remainder)) {
                return new int[] { numMap.get(remainder), i };
            }
            numMap.put(nums[i], i);
        }
        return null;

    }

}
