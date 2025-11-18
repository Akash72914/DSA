class Solution {
    public int findFloor(int[] arr, int x) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] <= x) {
                ans = mid;          // possible answer
                low = mid + 1;      // try to find a larger valid value
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
