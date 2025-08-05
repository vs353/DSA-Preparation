package com.vaish.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task_3477 {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = fruits.length;
        ArrayList<Integer> f = new ArrayList<>();
        for (int val : fruits) {
            f.add(val);
        }
        ArrayList<Integer> b = new ArrayList<>();
        for (int val : baskets){
            b.add(val);
        }
        int i = 0;
        while (i < f.size()) {
            boolean placed = false;
            for (int j = 0; j < b.size(); j++) {
                if (f.get(i) <= b.get(j)) {
                    f.remove(i);
                    b.remove(j);
                    count--;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                i++;
            }
        }
        return count;
    }
}
