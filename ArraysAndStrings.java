// Navon Francis
//
// Cracking the Coding Interview Arrays and Strings section
//
// Is Unique: Implement an algorithm to determine if a string has all
// unique characters.
// What if you cannot use additional data structures?
//
// Check Permutation: Given two strings, write a method to decide if
// one is a permutation of the other.
// David's wifi password: c941fb27
// I study with my friend david, this is why I have his wifi password handy ;)
// This file probably won't compile right now.

import java.io.*;
import java.util.*;

public class ArraysAndStrings {

  public static void main(String[] args) {
    // isUnique()
    String nav = "nav";
    String hello = "hello";
    // System.out.println("Unique? " + nav + ": " + isUnique(nav));
    // // System.out.println("Unique? " + hello + ": " + isUnique(hello));
    // System.out.println("Quick unique..? " + nav + ": "
    // + isUniqueButQuickerAndShorter(nav));
    // System.out.println("Quick unique..? " + hello + ": "
    // + isUniqueButQuickerAndShorter(hello));

    // isPermutation()
    // System.out.println("is this a permutation? " + isPermutation("asdasgodddd", "ddddasdasog"));
    String str = "'Mr John Smith    '";
    int len = 13;
    System.out.println("Turn this string: " + str + ", into a URL:");
    System.out.println("urlified: " + urlify(str, len));
  }
  
  public static String urlify(String str, int len) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < len; i++) {
      if(str.charAt(i) == ' ')
        sb.append("%20");
      else
        sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  public static boolean isPermutation(String strOne, String strTwo) {
    // sort strings and then count, convert to char array, then sort array
    char[] newStringOne = strOne.toCharArray();
    char[] newStringTwo = strTwo.toCharArray();

    Arrays.sort(newStringOne);
    Arrays.sort(newStringTwo);

    String sortStrOne = new String(newStringOne);
    String sortStrTwo = new String(newStringTwo);

    System.out.println("1: " + sortStrOne + " 2: " + sortStrTwo);

    return sortStrOne.equals(sortStrTwo);
  }

  // public static boolean isUnique(String str) {
  //   // boolean array to check if each letter a alphabetical letter has been used.
  //   boolean chars[] = new boolean[26];
  //
  //   // return if string is larger than 280 chars, can't excede.
  //   if (str.length() > 26) {
  //     return false;
  //   }
  //
  //   for (int i=0; i<str.length(); i++) {
  //     // System.out.println(str.charAt(i) - 'a' + ":  " + str.charAt(i));
  //     if (chars[str.charAt(i) - 'a'] == true) {
  //       return false;
  //     }
  //     else {
  //       chars[str.charAt(i) - 'a'] = true;
  //     }
  //   }
  //
  //   return true;
  //   // Time Complexity: O(str.length()), generalized: O(n)
  //   // Space Complexity: O(1) because we never an array bigger than 26
  // }
  //
  // public static boolean isUniqueButQuickerAndShorter(String str) {
  //   // let's try and use a hashset boyos
  //   HashSet setty = new HashSet<String>();
  //
  //   for (int i=0; i<str.length(); i++) {
  //     if (setty.contains(str.charAt(i))) {
  //       return false;
  //     }
  //     else {
  //       setty.add(str.charAt(i));
  //     }
  //   }
  //   return true;
  // }

}
