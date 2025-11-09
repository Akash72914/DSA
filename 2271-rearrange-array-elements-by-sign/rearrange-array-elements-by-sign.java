class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int pos = 0; // even index for positive numbers
        int neg = 1; // odd index for negative numbers

        for (int num : nums) {
            if (num > 0) {
                result[pos] = num;
                pos += 2;
            } else {
                result[neg] = num;
                neg += 2;
            }
        }

        return result;
    }
}
