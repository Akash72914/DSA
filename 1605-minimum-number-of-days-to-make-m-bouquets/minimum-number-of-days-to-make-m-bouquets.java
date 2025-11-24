class Solution {
    private boolean canMake(int[] arr, int day, int m, int k) {
        int bouquets = 0;
        int count = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= day) {
                count++;
            } else {
                bouquets += (count / k);
                count = 0;
            }
        }

        bouquets += (count / k);

        if(bouquets >= m) {
            return true;
        } else {
            return false;
        }
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long need = (long)m * k;
        int ans = -1;

        if(need > n) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        int low = minDay;
        int high = maxDay;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canMake(bloomDay, mid, m, k) == true) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}