import java.util.*;

public class BundleBArrayProblems {

    public static void main(String[] args) {
        // Uncomment one test case at a time to run specific problems:

        // Problem 6: Reverse Array
        // reverseArray(new int[] {1, 2, 3, 4});

        // Problem 7: Max and Min in Array
        // findMaxMin(new int[] {3, 1, 7, 9, 2});

        // Problem 8: Find Duplicates (Set approach)
        // findDuplicatesSet(new int[] {1, 2, 3, 2, 4, 1, 5});

        // Problem 8: Find Duplicates (Map approach)
        // findDuplicatesMap(new int[] {1, 2, 3, 2, 4, 1, 5});

        //secondlargest(new int[] {3, 1, 7, 9, 2});
        arraysort(new int[] {3, 1, 7, 9, 2,5,4,3,2});
    }

    // ------------------------------------------------
    // Problem 6: Reverse an Array
    // ------------------------------------------------
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }

    // ------------------------------------------------
    // Problem 7: Find Max and Min in Array
    // ------------------------------------------------
    public static void findMaxMin(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int x : arr) {
            if (x > max) max = x;
            if (x < min) min = x;
        }

        System.out.println("Max: " + max + ", Min: " + min);
    }

    // ------------------------------------------------
    // Problem 8: Find Duplicates using Set
    // ------------------------------------------------
    public static void findDuplicatesSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> dups = new LinkedHashSet<>();

        for (int x : arr) {
            if (seen.contains(x)) {
                dups.add(x);
            } else {
                seen.add(x);
            }
        }

        if (dups.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicates: " + dups);
        }
    }

    // ------------------------------------------------
    // Problem 8: Find Duplicates using HashMap
    // ------------------------------------------------
    public static void findDuplicatesMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        boolean found = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println();
        }
    }


    public static void secondlargest(int[] arr){

        // Arrays.sort(arr);
        // System.out.println(arr[arr.length-2]);
        // 3, 1, 7, 9, 2
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;

        for(int x : arr){

            if(x>max){
                secondmax=max;
                max=x;                
            }                
            else if(x<max && x>secondmax)
            {
                secondmax = x;
            }
            else{
                continue;
            }
        }
        if(secondmax==Integer.MIN_VALUE){
            System.out.println("No second max value");
        }
        else{
            System.out.println(secondmax);
        }        
    }

    //sort an array


    public static void arraysort(int[] arr){

        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]){
        //             int temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(arr));
        //3,1,7,9,2
        //3, 1, 7, 9, 2,5,4,3,2
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Bubble sort: "+Arrays.toString(arr));



    }
} 
