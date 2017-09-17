// Navon Francis
//
// Cracking the Coding Interview Moderate Section

import java.io.*;
import java.util.*;

public class Moderate {

  public static void main(String[] args) {
    // number swapper, page 462
    int a = -900;
    int b = -4;
    System.out.println("Swap a: " + a + " Swap b: " + b);
    noTempVariableSwap(a, b);

    // contiguous sequence, page 498
    int[] arr = {2, 3, -8, -1, 2, 4, -2, 3};
    System.out.println("The sum is : " + maxSequence(arr));
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

  public static void noTempVariableSwap(int a, int b) {
    // we find the diff, in this case.
    // diff = a (bigger) - b (smaller)
    a = a - b;

    // now, diff + smaller number. this gives us the bigger number
    // b (was smaller number) = a (diff) + b (small)
    b = a + b;

    // now, bigger - diff. this gives us the smaller number
    // a = b (newly switched bigger number) - a (diff)
    a = b - a;

    // we acheived a swap without using a temp variable
    System.out.println("Swapped a: " + a + " Swapped b: " + b);
  }

}
