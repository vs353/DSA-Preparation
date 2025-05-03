package com.zoho.main;

import com.strivers.linkedlist.LengthOfLinkedList;
import com.strivers.linkedlist.Node;
import com.zoho.problems.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int N = 43;
        int[] nums = {1,2,3,3,4,4,1,2,5,6,7};
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
//LL
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


//        Daimond_Pattern.daimondPattern(n);
//        Daimond_Pattern.pattern28(n);
//        Remove_Duplicates.RemoveDuplicates(nums);
//        Sort_OddEven.sortOddEven(arr);
//        int ans = Twisted_Prime_Number.isTwistedPrime(N);
//        System.out.println(ans);
//        Move_Zeroes_End.pushZerosToEnd(arr);
//        LengthOfLinkedList ll = new LengthOfLinkedList();
//        ll.lengthOfLL();

        LengthOfLinkedList.lengthOfLL(n1);
        // Single LinkedList
    }
}
