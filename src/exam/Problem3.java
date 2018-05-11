package exam;

/***
 * Implement any sort algorithm
 *
 */

class AnySort {
    void sort(int[] array) {
        //TODO: Put your code here
    }
}


public class Problem3 {
    private static int[] clone(int[] array) {
        int[] clone = new int[array.length];
        System.arraycopy(array, 0, clone, 0, array.length);
        return clone;
    }

    private static void print(int[] array) {
        //System.out.println("Array after stored!");
        for (int v : array) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AnySort sorter = new AnySort();
        int[] input = {2, 4, 5, 0, 12, 1, 1, 3, 3, 12, 14};

        sorter.sort(input);
        print(input);
    }
}
