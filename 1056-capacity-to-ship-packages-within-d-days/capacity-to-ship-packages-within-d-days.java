class Solution {
    private int daysRequired(int[] weights, int cap) {
        int day = 1;
        int load = 0;

        for(int i = 0; i < weights.length; i++) {
            int w = weights[i];

            if(load + w > cap) {
                day++;
                load = w;
            } else {
                load += w;
            }
        }

        return day;
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int reqDays = daysRequired(weights, mid);

            if(reqDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}