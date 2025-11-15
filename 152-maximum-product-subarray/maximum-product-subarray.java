class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int currMax = nums[0];
        int currMin = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int val = nums[i];

            // If val is negative, swap max and min
            if (val < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(val, currMax * val);
            currMin = Math.min(val, currMin * val);

            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}