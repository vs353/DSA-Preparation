package com.vaish.main;

import com.vaish.concepts.digits.CountDigits;
import com.vaish.concepts.recursion.*;
import com.vaish.practice.*;
import com.vaish.practice.geeksforgeeks.CountDigit;
import com.vaish.practice.geeksforgeeks.HashingFrequencies;
import com.vaish.practice.geeksforgeeks.Largest_Element_in_Array;
import com.vaish.practice.leetcode.array.CheckArrayIsSorted_1752;
import com.vaish.practice.leetcode.array.RemoveDuplicates_26;
import com.vaish.practice.leetcode.digits.ReverseInteger_7;
import com.vaish.practice.leetcode.hashing.EqualPairs_2206;
import com.vaish.practice.leetcode.hashing.FirstUniqueChar_387;
import com.vaish.practice.leetcode.hashing.FrequentElement_1838;
import com.vaish.practice.leetcode.bitmanipulation.LongestNiceSubarray_2401;
import com.vaish.practice.leetcode.bitmanipulation.AddBinary_67;
import com.vaish.practice.geeksforgeeks.Second_Largest;

import java.util.Arrays;

import static com.vaish.concepts.recursion.Recursion.f;
import static com.vaish.practice.IisHappy.isHappy;
import static com.vaish.practice.IsPrime.isPrimeNumber;
import static com.vaish.practice.MySqrt.mySqrt;
//import static com.vaish.practice.MySqrt.mySqrt;


public class Main {
    public static void main(String[] args) {
//     System.out.println("HELLO World");
//     Arrays.sample();
//     int countDigits = CountDigits.countDigits(797);
//     System.out.println(countDigits);
//     int reverseNumbers = reverseNumbers(10400);
//     System.out.println(reverseNumbers);
//     boolean palindromNumber = palindromeNumbers(122);
//     System.out.println(palindromNumber);
//     boolean isArmstrongNumber = armstrongNumber(371);
//     System.out.println(isArmstrongNumber);
//
//      int prime =
//              printDivisions(10);
//        System.out.println(prime);
//        int isPrime = isPrime(10);
//        System.out.println(isPrime);
//        int isGCD_HCF = isGCD_HCF(20,40);
//        System.out.println(isGCD_HCF);

//        boolean isPrimeNumber = isPrimeNumber(7);
//        System.out.println(isPrimeNumber);

//        int mySqrt = mySqrt(2147483647);
//        System.out.println(mySqrt);

//          boolean isHappy = isHappy(19);
//          System.out.println(isHappy);

//             Pattern.isPattern(3);
//        System.out.println(mySqrt(345366));
//        int[] digits = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,0,0,0};
//        System.out.println(Arrays.toString(PlusOne.plusOne(digits)));

//        int[] digits = {1,2,3};
//        System.out.println(Arrays.toString(PlusOne1.plusOne1(digits)));

/* Tasks */
//        Task1_0403.gettingArrayFromUser();
//        Task2_0403.reverseArray();
//Task3_0403.arraySum();
//       Task4_0403.evenIndex();
//Task5_0403.oddIndex();
//        Task6_0403.evenNumInArray();
//        Task6_0403.oddNumInArray();
        /* Recursion */
//        f();
//        int i = 1;
//        int n = 3;
//        int sum =0;
//        RecPrintName.printNames(i,n);
//        RecLinearly.print1ToN(i,n);
//        RecLinearly.reverseNTo1(n,n);
//        RecLinearlyByBacktracking.linearlyByBacktracking(n,n);
//        RecLinearlyByBacktracking.reverseLinearlyByBT(i,n);
//        RecParameter.recParameter(n,sum);
//        System.out.println(RecParameter.recFunctional(n));
//        System.out.println(RecParameter.recFactorial(n));
//        int[] arr = {1,2,3,4,2};
//        int l = 0;
//        int r = arr.length-1;
//        int [] ans = RecArray.swapArray( arr, l, r);
//        System.out.println(Arrays.toString(ans));
//
//        int [] fin = RecArray.singleParameter( arr, l);
//        System.out.println(Arrays.toString(fin));

//        char[] s = "madam".toCharArray();
//        int i = 0;
//        System.out.println(RecPalindrome.isPalindrome(s,i));

//        int n = 8;
//        int x = 1;
//        System.out.println(RecFib.recFibonacci(n));
//        System.out.println(recPowerTwo.isPowerTwo(n, x));
//        int[] arr = {499,500};
//        HashingFrequencies.frequencyCount(arr);
//        boolean an = EqualPairs_2206.divideArray(arr);
//        System.out.println(an);
//        int[] nums = {1,3,8,48,10};
//        int k = 2;
//
//        int count = FrequentElement_1838.maxFrequency(nums,k);
//        System.out.println(count);
//
//        int counter = LongestNiceSubarray_2401.longestNiceSubarray(nums);
//        System.out.println(counter);

//        String a = "11";
//        String b = "1";
//        String s = AddBinary_67.addBinary(a,b);
//        System.out.println(s);
//        String s = "leetcode";
//        int ans = FirstUniqueChar_387.firstUniqChar(s);
//        System.out.println(ans);
//        int n = 39;
//        System.out.println(CountDigit.evenlyDivides(n));
//        int x = 1534236469;
//        int ans = ReverseInteger_7.reverse(x);
//        System.out.println(ans);
       int[] arr={1,1,2};
//       int ans = Second_Largest.getSecondLargest(arr);
//       int ans =  Largest_Element_in_Array.largest(arr);
//        System.out.println(ans);
//        boolean check = CheckArrayIsSorted_1752.check(arr);
//        System.out.println(check);
        int removeDuplicates = RemoveDuplicates_26.removeDuplicates(arr);
        System.out.println(removeDuplicates);
    }
}
