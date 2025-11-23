class Solution {
    private long banana(int[] arr, int hourly) {
        long totalHour = 0;

        for(int i=0; i<arr.length; i++) {
            totalHour += (arr[i] + hourly - 1) / hourly;
        }

        return totalHour;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;

        for(int i=0; i<n; i++) {
            high = Math.max(high, piles[i]);
        }

        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            long hoursNeeded = banana(piles, mid);

            if(hoursNeeded <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}