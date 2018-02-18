// Navon Francis
// Well overdue stack class
// Array implementation
// I am really bored..

import java.util.*;
import java.io.*;

public class stack {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String command = "";
    Stacky s = new Stacky();

    while(true) {
      System.out.println("What would you like to do? [make, push, pop, print, peek, end]");
      command = sc.next();

      if(command.equals("make")) {
        System.out.println("How big of a stack?");
        int size = sc.nextInt();
        s = new Stacky(size);
        System.out.println("You created your stack of size " + size + "!");
      }
      else if(command.equals("push")) {
        int dPush = sc.nextInt();
        s.push(dPush);
        System.out.println("You pushed " + dPush + " onto the stack! pointer: " + s.pointer);
      }
      else if(command.equals("pop")) {
        int dPop = s.peek();
        s.pop();
        System.out.println("You popped " + dPop + " from the stack!");
      }
      else if(command.equals("print")) {
        s.print();
      }
      else if(command.equals("peek")) {
        System.out.println("The top of the stack: " + s.peek());
      }
      else if(command.equals("end")) {
        break;
      }
    }

  }

  static class Stacky {
    public int[] arr;
    public int pointer;
    public int size;

    Stacky() {
      arr = new int[3];
      pointer = 0;
    }

    Stacky(int stackSize) {
      arr = new int[stackSize];
      pointer = 0;
      size = stackSize;
    }

    public void push(int data) {
      if(pointer == size) {
        System.out.println("Stack full.");
      }
      else {
        arr[pointer] = data;
        pointer++;
      }
    }

    public void pop() {
      if(pointer < 0) {
        pointer = 0;
      }
      else if(pointer >= size) {
        arr[pointer-1] = 0;
        pointer--;
      }
      else {
        arr[pointer] = 0;
        pointer--;
      }
    }

    public int peek() {
      if(pointer > 0) {
        return arr[pointer-1];
      }
      else if(pointer >= size) {
        return arr[pointer-1];
      }

      return 0;
    }

    public void print() {
      if(pointer == 1) {
        System.out.print("[" + arr[0] + "]\n");
      }
      else {
        for(int i = 0; i < pointer; i++) {
          if(i == 0)
            System.out.print("[" + arr[i] + ", ");
          else if(i < pointer-1)
            System.out.print(arr[i] + ", ");
          else
            System.out.print(arr[i] + "]\n");
        }
      }
    }
  }

}
