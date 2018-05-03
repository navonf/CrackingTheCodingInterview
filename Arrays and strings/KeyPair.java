/*
Given an array A[] of n numbers and another number x, determine whether or not there exist two elements in A whose sum is exactly x.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and X,N is the size of array.
The second line of each test case contains N integers representing array elements C[i].

Output:

Print "Yes" if there exist two elements in A whose sum is exactly x, else "No" without quotes.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 200
1 ≤ C[i] ≤ 1000

Example:

Input:
2
6 16
1 4 45 6 10 8
5 10
1 2 4 3 6

Output:
Yes
Yes
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class KeyPair {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for(int i=0; i<n; i++) {
      int len = sc.nextInt();
      int addsToMe = sc.nextInt();
      HashSet<Integer> set = new HashSet<Integer>();

      for(int j=0; i<len; i++) {
        
      }
    }
  }
}
