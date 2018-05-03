/* Navon. */

/*
 * Merge sort!
 * Usually done recursively, and closely related to divide and conquer.
 * A great O(nlogn) sort, usually better than Quick sort in some areas.
 *
 * So how do we do it?
 * 1. Continously split the area in half until we divide up all the items.
 *    We do this step until the array is broken down into single arrays.
 *    This means each single element is sorted.
 *    [10, 18, 2, 14, 1, 9, 1, 20]
 *    [10, 18, 2, 14] [1, 9, 1, 20]
 *    [10, 18] [2, 14] [1, 9] [1, 20]
 *    [10] [18] [2] [14] [1] [9] [1] [20]      * Every SINGLE element is sorted.
 * 2. Examine individual items, compare the items, merge them into temp arrays.
 *    This is the actual sorting step.
 *    [10] [18] [2] [14] [1] [9] [1] [20]
 *    [10, 18] [2, 14] [1, 9] [1, 20]
 *    [2, 10, 14, 18] [1, 1, 9, 20]
 *    [1, 1, 2, 9, 10, 14, 18, 20]
 */

import java.util.*;

public class mergesort {

  public static void main(String[] args) {
    int[] arr = {10, 18, 2, 14, 3, 12};
    System.out.println("unsorted: " + Arrays.toString(arr));
    System.out.println("sorted:   " + Arrays.toString(mergeSort(arr)));
  }

  public static int[] mergeSort(int[] array) {
    return mergeSort(array, 0, array.length - 1);
  }

  // recursive part
  public static int[] mergeSort(int[] array, int lo, int hi) {
    // we will split until they are each a singly sorted array.
    // or in the case of the array is already 1.
    if(lo >= hi)
      return null;

    // lo pointer is begining index of first array
    // hi is the last index of
    int mid = lo + (hi - lo) / 2;

    // make the two arrays, based upon halfed size.
    // the first array goes from a[0..n/2]
    // the second array goes from a[n/2 + 1..n]
    mergeSort(array, lo, mid);
    mergeSort(array, mid + 1, hi);

    // merging the two arrays back together.
    int[] merge = new int[hi - lo + 1];
    int i = lo;
    int j = mid + 1;
    int k = 0;

    while (i <= mid || j <= hi) {
      if (j > hi)
        merge[k++] = array[i++];
      else if (i > mid)
        merge[k++] = array[j++];
      else if (array[i] < array[j])
        merge[k++] = array[i++];
      else
        merge[k++] = array[j++];
    }

    for (i = lo; i <= hi; i++)
			array[i] = merge[i - lo];

    return array;
  }

}
