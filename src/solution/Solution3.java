package solution;

/***
 * Implement any sort algorithm
 *
 */

class AnySort {
    void bubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
    }

    void selection(int[] array) {
        for (int i = 0; i < array.length; i++) {

            // select the minimum element
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            int swap = array[min];
            array[min] = array[i];
            array[i] = swap;
        }
    }

    void insertion(int[] array) {
        for (int i = 0; i < array.length; i++) {

            // start with insert point
            int insert = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > insert; j--) {
                // move to the right
                array[j + 1] = array[j];
            }
            // place the insert
            array[j + 1] = insert;
        }
    }
}


public class Solution3 {
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
        AnySort sort = new AnySort();

        int[] input = {2, 4, 5, 0, 12, 1, 1, 3, 3, 12, 14};

        System.out.println("Bubble Sort...");
        int[] array = clone(input);
        sort.bubble(array);
        print(array);

        System.out.println("Selection Sort...");
        array = clone(input);
        sort.selection(array);
        print(array);

        System.out.println("Insertion Sort...");
        array = clone(input);
        sort.insertion(array);
        print(array);
    }
}
