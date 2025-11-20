class Solution {
    int countFreq(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        
        for(int i=0; i<n; i++) {
            if(arr[i] == target) {
                count++;
            }
        }
        
        return count;
    }
}
