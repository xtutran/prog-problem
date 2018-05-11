package exam;


/***
 * Implement quick sort algorithm
 *
 */
class QuickSort {

    void sort(int[] array) {
        //TODO: Put your code here
    }
}


public class Problem2 {
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
