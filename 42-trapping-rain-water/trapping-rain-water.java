import java.util.*;

class Solution {
    public int trap(int height[]) {
        int n = height.length;

        //calulate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //calulate right max boundary
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        //loop
        for(int i=0; i<n; i++) {
            //waterLevel = min(leftmax boundry, rightmax boundary)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            //trappedWter = waterLevel - height[i]
            trappedWater += waterLevel - height[i]; 
        }

        return trappedWater;
    }
}