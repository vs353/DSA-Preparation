package com.vaish.main;

import com.vaish.concepts.arrays.Arrays;
import com.vaish.concepts.digits.CountDigits;

import static com.vaish.concepts.digits.ArmstrongNumber.armstrongNumber;
import static com.vaish.concepts.digits.CheckForPrime.isPrime;
import static com.vaish.concepts.digits.GCD_HCF.isGCD_HCF;
import static com.vaish.concepts.digits.PalindromeNumber.palindromeNumbers;
import static com.vaish.concepts.digits.PrintAllDivisions.printDivisions;
import static com.vaish.concepts.digits.ReverseNumber.reverseNumbers;

public class Main {
    public static void main(String[] args) {
     System.out.println("HELLO World");
     Arrays.sample();
     int countDigits = CountDigits.countDigits(797);
     System.out.println(countDigits);
     int reverseNumbers = reverseNumbers(10400);
     System.out.println(reverseNumbers);
     boolean palindromNumber = palindromeNumbers(122);
     System.out.println(palindromNumber);
     boolean isArmstrongNumber = armstrongNumber(371);
     System.out.println(isArmstrongNumber);

        printDivisions(36);
        boolean isPrime = isPrime(7);
        System.out.println(isPrime);
        int isGCD_HCF = isGCD_HCF(20,40);
        System.out.println(isGCD_HCF);

    }
}
