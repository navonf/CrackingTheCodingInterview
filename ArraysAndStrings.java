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


import java.io.*;
import java.util.*;

public class ArraysAndStrings {

  public static void main(String[] args) {
    String nav = "nav";
    String hello = "hello";
    System.out.println("Unique? " + nav + ": " + isUnique(nav));
    System.out.println("Unique? " + hello + ": " + isUnique(hello));
    System.out.println("Quick unique..? " + nav + ": " + isUniqueButQuickerAndShorter(nav));
    System.out.println("Quick unique..? " + hello + ": " + isUniqueButQuickerAndShorter(hello));
  }

  public static boolean isUnique(String str) {
    // boolean array to check if each letter a alphabetical letter has been used.
    boolean chars[] = new boolean[26];

    // return if string is larger than 280 chars, can't excede.
    if (str.length() > 26) {
      return false;
    }

    for(int i=0; i<str.length(); i++) {
      // System.out.println(str.charAt(i) - 'a' + ":  " + str.charAt(i));
      if (chars[str.charAt(i) - 'a'] == true) {
        return false;
      }
      else {
        chars[str.charAt(i) - 'a'] = true;
      }
    }

    return true;
    // Time Complexity: O(str.length()), generalized: O(n)
    // Space Complexity: O(1) because we never an array bigger than 26
  }

  public static boolean isUniqueButQuickerAndShorter(String str) {
    // let's try and use a hashset boyos
    HashSet setty = new HashSet<String>();

    for (int i=0; i<str.length(); i++) {
      if (setty.contains(str.charAt(i))) {
        return false;
      }
      else {
        setty.add(str.charAt(i));
      }
    }
    return true;
  }

}
