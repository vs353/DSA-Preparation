package com.strivers.arrays.easy;

import java.util.*;

public class ZerosLast {
    public static boolean isSubsequence(String s, String t) {
        int count =0;
        int n = s.length();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                count++;
            }
            j++;
        }
if(count==s.length()){
    return true;
}
//        if (i == s.length()) {
//            System.out.println("Yes, 'abc' is a subsequence of 'ahbgdc'");
//        } else {
//            System.out.println("No");
//        }

//        List<String> ss = new ArrayList<>();
//        for (int i =0 ; i<s.length(); i++){
//            ss.add(String.valueOf(s[i]));
//        }
//        List<String> tt = new ArrayList<>();
//        for(int i =0; i<t.length(); i++){
//            tt.add(String.valueOf(i));
//        }
//        System.out.println(ss);
//        System.out.println(tt);
//        if(count == n){
//            return true;
//        }
        return false;
    }
    public static int singleNumber(int[] nums) {
        int count =0;
        for(int i =0; i<nums.length; i++){
            int num = nums[i];
            for(int j =0; j<nums.length ; j++){
                if(num == nums[j]){
                    count++;
                }
            }
            if(count ==1){
                return num;
            }
            else{
                count =0;
            }
        }
        return 0;
    }
    public static String[] findRelativeRanks(int[] score) {
        ArrayList<String> list = new ArrayList<>();
        int [] copy = score.clone();
        if(score.length==1){
            list.add("Gold Medal");
        }
        else {
            Arrays.sort(score);
            int gm = score[score.length-1];
            int sm = score[score.length-2];
            int bm = score[score.length-3];
            for(int i = 0; i<score.length; i++){
                if(score[i] == gm){
                    list.add("Gold Medal");
                }
                else if(score[i] ==sm){
                    list.add("Silver Medal");
                }
                else if(score[i] ==bm){
                    list.add("Bronze Medal");
                }
            }
            System.out.println(list);
            int i =0;
            for(String ss : list){
                if(gm == copy[i]){
                    copy[i] = Integer.parseInt(list.get(2));
                }
                else if (sm == copy[i]){
                    copy[i] = Integer.parseInt(list.get(1));
                } else if (bm == copy[i]) {
                    copy[i] = Integer.parseInt(list.get(0));
                }
            }
//            for(int i =0; i<copy.length;i++){
//                if(gm == copy[i]){
//                    copy[i] = Integer.parseInt(list.get(2));
//                }
//                else if (sm == copy[i]){
//                    copy[i] = Integer.parseInt(list.get(1));
//                } else if (bm == copy[i]) {
//                    copy[i] = Integer.parseInt(list.get(0));
//                }
//            }
        }

        String[] s = new String[copy.length];
        for(int i =0; i<copy.length; i++){
            s[i] = String.valueOf(copy[i]);
        }
        return s;
    }
    public static void duplicateZeros(int[] arr) {
        int s = 0;
        List<Integer> list = new ArrayList<>();
        while(s< arr.length){
            if(arr[s]==0){
                list.add(arr[s]);
                list.add(0);
                s++;
            }
            else {
                list.add(arr[s]);
                s++;
            }
        }
       for(int i =0; i<=arr.length-1; i++){
           arr[i] = list.get(i);
       }
        System.out.println(Arrays.toString(arr));
    }
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
      ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
      int i =0;
      int j = 0;
      int temp =-1;

      while (i<a.length && j<b.length){
          if(a[i]<=b[j] && a[i]>temp){
              list.add(a[i]);
              temp = a[i];
              i++;
          }
          else if(b[j]>temp) {
              list.add(b[j]);
              temp = b[j];
              j++;
          }
          else {
              if (a[i] > temp) {
                  list.add(a[i]);
                  temp = a[i];
              }
              i++;
              j++;
          }
      }
        while (i < a.length) {
            if (a[i] > temp) {
                list.add(a[i]);
                temp = a[i];
            }
            i++;
        }

        // Add remaining elements from b
        while (j < b.length) {
            if (b[j] > temp) {
                list.add(b[j]);
                temp = b[j];
            }
            j++;
        }

       return list;
    }
    public static int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> union = new HashSet<>();
        for(int i = 0; i<nums1.length ; i++){
            union.add(nums1[i]);
        }
        for(int i =0; i<nums2.length ; i++){
            union.add(nums2[i]);
        }
        int[] u = new int[union.size()];
        int i = 0;
        for (int num : union) {
            u[i++] = num;
        }
        return u;
    }
    public static void moveZeroes(int[] nums) {
        int j = -1;
        for(int i = 0; i<nums.length ;i++){
            if(nums[i]==0){
                j= i;
                break;
            }
        }
        for(int i = j+1; i<nums.length; i++){
            if(nums[i]!=0){
                //swap(nums[i], nums[j]);
               int temp = nums[i];
               nums[i] = nums[j];
               nums[j] = temp;
                j++;
            }
        }
//       List<Integer> temp = new ArrayList<>();
//       for(int i =0; i< nums.length ; i++){
//           if(nums[i]!=0){
//               temp.add(nums[i]);
//           }
//       }
//       int nonZeros = temp.size();
//       for(int i =0; i< temp.size();i++){
//           nums[i] = temp.get(i);
//       }
//       for(int i = nonZeros; i<nums.length; i++){
//           nums[i] =0;
//       }
        System.out.println(Arrays.toString(nums));
    }
    public static void moveAllZerosToLast(int[] arr){
        int n = arr.length-1;
        List<Integer> temp = new ArrayList<>();
        for(int i =0; i<=n; i++){
            if(arr[i]!=0){
           temp.add(arr[i]);
            }
        }
        for(int i = 0; i<temp.size();i++){
            arr[i] = temp.get(i);
        }
       int noOfZeros = temp.size();
        for(int i =noOfZeros;i<=n;i++){
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int[] optimalSolutinZerosToLast(int[]arr){
        int j = -1;
        int n = arr.length;
        for(int i= 0 ; i<n; i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1){
            return arr;
        }
        for(int i = j+1; i<n; i++){
            if(arr[i]!=0){
                swap(arr[i],arr[j]);
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static void swap(int i, int j) {
        int temp = i;
        i=j;
        j=temp;
    }
}
