class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        //int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;

            for(int i=0; i<n; i++) {
                sum += (int) Math.ceil((double)nums[i] / mid);
            }

            if(sum <= threshold) {
                //ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}