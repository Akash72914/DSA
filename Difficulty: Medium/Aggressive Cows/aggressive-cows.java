class Solution {
    private boolean canWePlace(int[] arr, int dist, int cows) {
        int cntCows = 1;
        int last = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            
            if(arr[i] - last >= dist) {
                cntCows++;
                last = arr[i];
            }
           
        }
        
         
        if(cntCows >= cows) {
            return true;
        } else {
            return false;
        }
    }
    
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        
        int high = Arrays.stream(stalls).max().getAsInt();
        int low = 1;
        int ans = 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(canWePlace(stalls, mid, k) == true) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
}