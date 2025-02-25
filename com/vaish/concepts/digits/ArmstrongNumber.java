package com.vaish.concepts.digits;

public class ArmstrongNumber {
    public static boolean armstrongNumber(int n) {
        int lastdigit = 0;
        int sum = 0;
        int org = n;
        while (n > 0) {
            lastdigit = n % 10;
            sum = sum + (lastdigit * lastdigit* lastdigit);
            n= n/10;
        }
        return org == sum;
    }
}
