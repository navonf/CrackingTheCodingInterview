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
  public static final Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    // isUnique()
    // String nav = "nav";
    // String hello = "hello";
    // System.out.println("Unique? " + nav + ": " + isUnique(nav));
    // System.out.println("Unique? " + hello + ": " + isUnique(hello));
    // System.out.println("Quick unique..? " + nav + ": "
    // + isUniqueButQuickerAndShorter(nav));
    // System.out.println("Quick unique..? " + hello + ": "
    // + isUniqueButQuickerAndShorter(hello));

    // isPermutation()
    // System.out.println("is this a permutation? " + isPermutation("yolo", "oloy"));
    // String str = "'Mr John Jacob hello
    // int len = 19;
    // System.out.println("Turn this string: " + str + ", into a URL:");
    // System.out.println("urlified: " + urlify(str, len));
    //

    // compress()
    // String comp = "aabcccccaaa";
    // String same = "abcd";
    // System.out.println("uncompressed: " + comp + ", compressed string: " + compress(comp));
    // System.out.println("uncompressed: " + same + ", compressed string: " + compress(same));

    // permutations()
    System.out.println("Enter a string to permute: ");
    // System.out.println(permutations(sc.next(), new ArrayList<String>()));
    permutations(sc.next(), new ArrayList<String>());


  }

  public static String compress(String str) {
    // setting up our counter for the amount of consecutive letters.
    int count = 0;
    int finalLen = countCompression(str);
    if(finalLen > str.length()) {
      System.out.println("you returned early! nice");
      return str;
    }

    StringBuilder sb = new StringBuilder(finalLen);

    for(int i = 0; i < str.length(); i++) {
      count++;
      if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        sb.append(str.charAt(i));
        sb.append(count);
        count = 0;
      }
    }

    return sb.length() < str.length() ? sb.toString() : str;

  }

  private static int countCompression(String str) {
    int count = 0;
    int compressed = 0;
    for(int i = 0; i < str.length(); i++) {
      count++;
      if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        compressed += 2;
        count = 0;
      }
    }

    return compressed;
  }

  public static String urlify(String str, int len) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < len+1; i++) {
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

    String sortedStrOne = new String(newStringOne);
    String sortedStrTwo = new String(newStringTwo);

    System.out.println("1: " + sortedStrOne + " 2: " + sortedStrTwo);

    return sortedStrOne.equals(sortedStrTwo);
  }

  public static boolean isUnique(String str) {
    // boolean array to check if each letter a alphabetical letter has been used.
    boolean chars[] = new boolean[26];

    // return if string is larger than 280 chars, can't excede.
    if (str.length() > 26) {
      return false;
    }

    for (int i=0; i<str.length(); i++) {
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
    HashSet<Character> setty = new HashSet<Character>();

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

  public static ArrayList<String> permutations(String s, ArrayList<String> r) {
    permutations("", s, r);
    return r;
  }

  private static void permutations(String prefix, String suffix, ArrayList<String> result) {
    if(suffix.length() == 0) {
      result.add(prefix);
    }
    else {
      // iterate through, p("a", bc), p("b", ac), ..etc
      for(int i = 0; i < suffix.length(); i++) {
        // System.out.println(suffix.substring(0, i) + " " + suffix.substring(i + 1, suffix.length()));
        permutations(prefix + suffix.charAt(i),
        suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), result);
      }
    }
  }

}
