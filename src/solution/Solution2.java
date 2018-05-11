package solution;


/***
 * Implement quick sort algorithm
 *
 */
class QuickSort {

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i = i + 1;
                int swap = array[j];
                array[j] = array[i];
                array[i] = swap;
            }
        }
        if (array[high] < array[i+1]) {
            int swap = array[high];
            array[high] = array[i+1];
            array[i+1] = swap;
        }
        return i + 1;
    }

    private void quick(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);

            quick(array, low, p - 1);
            quick(array, p + 1, high);
        }
    }

    void sort(int[] array) {
        quick(array, 0, array.length - 1);
    }
}

public class Solution2 {
    public static void main(String[] args) {
        QuickSort quick = new QuickSort();
        int[] array = {2, 4, 5, 0, 12, 1, 1, 3, 3, 12, 14};
        quick.sort(array);

        System.out.println("Array after stored!");
        for (int v : array) {
            System.out.print(v + " ");
        }
    }
}
