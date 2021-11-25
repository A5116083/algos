package com.bloomberg;

import java.util.*;

public class ThreeSumToZero {

    static List<List<Integer>>  twoSum(int[] arr, HashSet<Integer> set, int start, int S ){
       HashSet<Integer> seen= new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i=start;i< arr.length; i++){
            if(seen.add(arr[i])) {
                int sub = S - arr[i];
                if (set.contains(sub)) {
                   // if(!seen.containsKey(sub) || (!seen.containsKey(arr[i]))) {
                        List<Integer> matched = Arrays.asList(arr[i], sub);
                        result.add(matched);
                       // seen.put(arr[i],sub);
                    }
                }
            }
        //}
        return result;
    }
    static  List<List<Integer>> threeSum(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i < nums.length;i++){
            set.add(nums[i]);
        }

        for (int i=0;i< nums.length;i++){
            int negagte = -nums[i] ;
            List<List<Integer>> res= twoSum(nums, set, i+1, negagte);

            if(res.size() > 0 ){

                res.forEach(items-> {
                    result.add(Arrays.asList(-negagte,items.get(0),items.get(1)));
                });

            }
        }
        return result;

    }

    public static class ThreeSumTwoPointer{

        List<List<Integer>> threeSum(int[] arr){
            Arrays.sort(arr);
            List<List<Integer>> res= new ArrayList<>();
            for(int i=0;i < arr.length;i++){

                if(i==0 || arr[i-1]!=arr[i]){
                    twoSumII(arr,i,res);
                }
            }
            return res;
        }

        void twoSumII(int[] arr, int i, List<List<Integer>> res){
            int lo = i + 1, hi = arr.length - 1;

            while (lo<hi){

                int sum = arr[i] + arr[lo] + arr[hi];
                if(sum < 0){
                    ++lo;
                }else if (sum >0 ){
                    --hi;
                }else {
                    res.add(Arrays.asList(arr[i], arr[lo++], arr[hi--]));
                    while (lo < hi && arr[lo] == arr[lo - 1])
                        ++lo;
                }

            }
        }

    }

    public static class ThreeSumHash{

        List<List<Integer>> threeSum(int[] arr){
            Arrays.sort(arr);
            List<List<Integer>> res= new ArrayList<>();
            for(int i=0;i < arr.length;i++){

                if(i==0 || arr[i-1]!=arr[i]){
                    twoSumII(arr,i,res);
                }
            }
            return res;
        }

        void twoSumII(int[] arr, int i, List<List<Integer>> res){
            HashSet<Integer> seen = new HashSet<>();
            for(int j=i+1; i < arr.length; j++){

                int complement = -arr[i] - arr[j];
                if(seen.contains(complement)){
                    res.add(Arrays.asList(arr[i], arr[j], complement));
                    while (j + 1 < arr.length && arr[j] == arr[j + 1])
                        ++j;
                }
                seen.add(arr[j]);

            }
        }

    }





    public static void main(String[] args) {

        ThreeSumTwoPointer threeSum = new ThreeSumTwoPointer();
       List<List<Integer>> res=  threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        ThreeSumHash threeSumHash = new ThreeSumHash();
        List<List<Integer>> res1 = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(res);
        System.out.println(res1);
    }
}
