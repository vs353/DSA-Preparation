package com.strivers.linkedlist;

public class LengthOfLinkedList {
  public static void lengthOfLL(Node head){
      int count=0;
      Node temp = head;
      while(temp != null){
          temp = temp.next;
          count++;
      }
      System.out.println("Length Of Linked List - " + count);
    }
}
