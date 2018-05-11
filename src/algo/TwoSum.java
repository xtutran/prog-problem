package algo;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /***
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     *
     */

    // brute force O(n2) runtime O(1) space
    static int[] func1(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // using hashmap O(n) runtime O(n) space
    static int[] func2(int[] A, int target) {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (store.containsKey(target - A[i])) {
                return new int[] {store.get(target - A[i]), i};
            }
            store.put(A[i], i);
        }
        return new int[]{-1, -1};
    }

    //binary search, assume: input is sorted O(nlogn) runtime O(1) space
    static int[] func3(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            int j = bSearch2(A, target - A[i], i + 1);
            //int j = bSearch(A, i + 1, A.length - 1, target - A[i]);

            if (j != -1) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    //binary search recursion
    static int bSearch(int[] A, int start, int end, int key) {

        if (start <= end) {
            int pivot = start + (end - start)/2;
            if (A[pivot] == key) {
                return pivot;
            } else if (A[pivot] > key) {
                return bSearch(A, start, pivot - 1, key);
            } else {
                return bSearch(A, pivot + 1, end, key);
            }
        } else {
            return -1;
        }
    }

    //binary search iterative
    static int bSearch2(int[] A, int key, int start) {
        int left = start;
        int right = A.length - 1;
        while(left <= right) {
            int pivot = left + (right - left) / 2; //fix issue (left + right)/2 => lead to infinite loop
            if (A[pivot] == key) {
                return pivot;
            } else if (A[pivot] < key) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return -1;
    }

    // expected & actual must be sorted
    static void assertEqual(int[] expected, int[] actual) {
        if (expected.length != actual.length) {
            throw new AssertionError("Failed! Expected & actual have different size");
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new AssertionError(String.format("Failed! expected: %d, but actual: %d", expected[i], actual[i]));
            }
        }
        System.out.println("Passed!");
    }

    static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Failed! expected: %d, but actual: %d", expected, actual));
        }
        System.out.println("Passed!");
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 10, 5, 10};

        //1.
        int[] output = func1(A, 20);
        assertEqual(new int[]{3, 5}, output);

        //2.
        output = func2(A, 20);
        assertEqual(new int[]{3, 5}, output);

        output = func2(A, 21);
        assertEqual(new int[]{-1, -1}, output);

        //3.
        //Binary Search
        int[] B = {1, 2, 4, 5, 5, 7, 10};

        assertEquals(bSearch(B, 0, B.length - 1, 8), -1); //-1 not found
        assertEquals(bSearch(B, 0, B.length - 1, 5), 3); //3 found
        assertEquals(bSearch(B, 0, B.length - 1, 7), 5); //5 found

        assertEquals(bSearch2(B, 5, 8), -1); //-1 not found
        assertEquals(bSearch2(B, 5, 4), 4); //4 found
        assertEquals(bSearch2(B, 7, 0), 5); //5 found

        //two sum
        output = func3(B, 10);
        assertEqual(new int[]{3, 4}, output);

        output = func3(B, 21);
        assertEqual(new int[]{-1, -1}, output);

    }
}
