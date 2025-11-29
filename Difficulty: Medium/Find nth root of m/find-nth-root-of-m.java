class Solution {
    private int fun(int num, int n) {
        int res = 1;
        
        for(int i=0; i<n; i++) {
            res = res * num;
        }
        
        return res;
    }
    
    public int nthRoot(int n, int m) {
        int low = 0;
        int high = m;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            int val = fun(mid, n);
            
            if(val == m) {
                return mid;
            } 
            else if(val > m) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}