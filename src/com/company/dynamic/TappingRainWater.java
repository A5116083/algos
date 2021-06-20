package com.company.dynamic;

public class TappingRainWater {

    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        int result= computeTrappedWater(arr);
        System.out.println("Maximum rain water trapped : "+ result);

    }

    static int computeTrappedWater(int[] height){
        int water=0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int n = height.length;

        for (int i=0; i < n; i++){
            if(i==0){
                leftMax[0]= height[i];
                rightMax[n-1]=height[n-1];
            }
            else{
                leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
                rightMax[n-i-1] = Math.max(rightMax[n-i], height[n-i-1]);
            }

        }

        for (int i=1; i< n-1;i++){
            water+= Math.min(leftMax[i], rightMax[i])- height[i];
        }

        return water;
    }
}
