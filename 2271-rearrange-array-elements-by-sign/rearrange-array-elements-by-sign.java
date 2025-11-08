class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = 0, k = 0;

        // First pass: place positives at even indices
        for (int p = 0; p < n; p++) {
            if (nums[p] > 0) {
                result[i] = nums[p];
                i += 2; // even index
            }
        }

        // Second pass: place negatives at odd indices
        for (int ne = 0; ne < n; ne++) {
            if (nums[ne] < 0) {
                result[j + 1] = nums[ne];
                j += 2; // odd index
            }
        }

        return result;
    }
}
