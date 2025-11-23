class Solution {
    int floorSqrt(int n) {
        int low = 0;
        int high = n;
        //int ans = 0;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(mid * mid > n) {
                high = mid - 1;
            } else if(mid * mid <= n) {
                //ans = mid;
                low = mid + 1;
            }
        }
        
        return high; //ans
    }
}