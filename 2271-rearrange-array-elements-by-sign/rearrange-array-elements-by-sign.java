class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        int p = 0, ne = 0;

        // Separate positive and negative numbers
        for (int num : nums) {
            if (num > 0) pos[p++] = num;
            else neg[ne++] = num;
        }

        int[] result = new int[n];
        int i = 0, j = 0, k = 0;

        // Alternate positive and negative
        while (i < p && j < ne) {
            result[k++] = pos[i++];
            result[k++] = neg[j++];
        }

        // Add remaining ones
        while (i < p) result[k++] = pos[i++];
        while (j < ne) result[k++] = neg[j++];

        return result;
    }
}