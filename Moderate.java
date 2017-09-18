// Navon Francis
//
// Cracking the Coding Interview Moderate Section

import java.io.*;
import java.util.*;

public class Moderate {

  public static void main(String[] args) {
    // number swapper, page 462
    System.out.println("Number swapper:");
    int a = 900;
    int b = 4000;
    System.out.println("a: " + a + " b: " + b);
    noTempVariableSwap(a, b);

    System.out.println();

    // word frequencies
    System.out.println("Word counter:");
    String[] book = new String[] {"how", "much", "wood", "could", "a", "woodchuck",
    "chuck", "if", "a", "chuck", "could", "chuck", "wood", "c huck"};
    String word = "chuck";
    System.out.println("Our String is: " + Arrays.toString(book));
    System.out.println("The word \"" + word + "\" appears: " + wordCount(book, word) + " times");

    System.out.println();

    // contiguous sequence, page 498
    System.out.println("Max contiguous sequence:");
    int[] arr = {2, 3, -8, -1, 2, 4, -2, 3};
    System.out.println("Sequence: " + Arrays.toString(arr));
    System.out.println("Greatest contiguous sum: " + maxSequence(arr));
  }

  public static int maxSequence(int[] array) {
    int sum = 0;
    int maxSum = 0;

    for(int i=0; i<array.length; i++) {
      if((array[i] + sum) > 0) {
        sum += array[i];
        maxSum = (sum > maxSum) ? sum : maxSum;
      } else {
        sum = 0;
      }
    }

    return maxSum;
  }

  public static void noTempVariableSwap(int a, int b) {
    // we find the diff, in this case.
    // diff = a - b
    a = a - b;

    // now, diff + second number will yeild first number
    // b  = a (diff) + b (second number)
    b = a + b;

    // now, first number - diff. this gives us the second number
    // a = b (newly switched second number) - a (diff)
    a = b - a;

    // we acheived a swap without using a temp variable
    System.out.println("Swapped a: " + a + " Swapped b: " + b);
  }

  public static int wordCount(String[] book, String word) {
    // shout out to @justinnp for the help on this one
    int count = 0;
    word = word.trim().toLowerCase();

    for(String w : book) {
      if(w.trim().toLowerCase().equals(word))
        count++;
    }
    return count;
  }

}
