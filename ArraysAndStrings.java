// Cracking the Coding Interview Arrays and Strings section

// Is Unique: Implement an algorithm to determine if a string has all
// unique characters.
//
// What if you cannot use additional data structures?
import java.io.*;
import java.util.*;

public class ArraysAndStrings {

  public static void main(String[] args) {

    isUnique("hello");
  }

  public static void isUnique(String str) {
    // boolean array to check if each letter a alphabetical letter has been used.
    boolean chars[] = new boolean[26];

    // return if string is larger than 280 chars, can't excede.
    if (str.length() > 280) {
      System.out.println("shit to long");
    }

    for(int i=0; i<str.length(); i++) {
      System.out.println(str.charAt(i) - 'a' + ":  " + str.charAt(i));
      if (chars[str.charAt(i) - 'a'] == true) {
        System.out.println("repeated character");
      }
      else {
        chars[str.charAt(i) - 'a'] = true;
        System.out.println("no repeat");
      }
    }
  }

}
