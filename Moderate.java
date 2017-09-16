// Navon Francis
//
// Cracking the Coding Interview Moderate Section

import java.io.*;
import java.util.*;

public class Moderate {

  public static void main(String[] args) {

    // contiguous sequence, page 498
    int[] a = {2, 3, -8, -1, 2, 4, -2, 3};
    System.out.println("The sum is : " + maxSequence(a));
  }

  public static int maxSequence(int[] array) {
    int sum = 0;
    int maxSum = 0;

    for(int i=0; i<array.length; i++) {
      if((array[i] + sum) > 0) {
        sum += array[i];
        maxSum = (sum > maxSum) ? sum : maxSum;
      }
      else {
        sum = 0;
      }
    }

    return maxSum;
  }

}
