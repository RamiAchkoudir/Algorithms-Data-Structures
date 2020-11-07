/*
Author: Rami Achkoudir
This code executes assignment 1-3, it sorts an array using insertionsort, counts and displays the number of swaps
and inversions. The sorting method compares an element to the next element, if the element is greater then we swap
index using a temp variable, and keep comparing with the previous elements
Whenever a swap is done the "counter" is incremented and printed out together with the array after the swap
The inversion method uses a double for-loop where we compare the first element with all the other elements with higher
index and increment the counter whenever we get to a higher value.
 */


public class InsertionSort {
    public static void main(String[] args) {
        int[] num = {1, 2, 4, 3, 5, 0};
        System.out.println(java.util.Arrays.toString(num));
        System.out.println();
        inversions(num);
        sorting (num);
        System.out.println (java.util.Arrays.toString(num));
    }

    /*
    Insertionsort method together with swaps counter
    */
    public static int [] sorting (int[] item) {
        int counter = 0;


        for (int i = 1; i < item.length; i ++) {
            int current = item [i];
            int j = i-1;
            while (j >= 0 && item[j]>current) {
                item[j+1] = item[j];
                j--;
                item[j+1] = current;
                counter++;
                System.out.println("Swap number: "+ counter);
                System.out.println (java.util.Arrays.toString (item));
            }
        }
        System.out.println("Number of swaps: "+ counter);
        return item;
    }

    /*
    The inversion method uses a double for-loop.
    It compares the first element with the second, third, fourth, etc...
    The time complexity for this method should be o(n^2)

     */
    public static int[] inversions(int[] item) {

        int inversions = 0;

        for (int i = 0; i < item.length - 1; i++) {
            for (int j = i + 1; j < item.length; j++) {
                if (item[i] > item[j]) {
                    inversions++;
                    System.out.println("Inversion: " + "[" + i + "," + item[i] + "]" + "[" + j + "," + item[j] + "]");
                }
            }
        }
        System.out.println("total inversions: " + inversions);
        return item;
    }
}