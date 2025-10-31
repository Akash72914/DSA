// User function Template for Java

import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Use long for sum to avoid overflow on large values
        long sum = 0;
        int maxLen = 0;
        HashMap<Long, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If prefix sum itself equals k, subarray [0..i] is valid
            if (sum == k) {
                maxLen = i + 1;
            }

            // If (sum - k) seen before, there is a subarray (prevIndex+1 .. i) with sum k
            if (firstIndex.containsKey(sum - k)) {
                int len = i - firstIndex.get(sum - k);
                if (len > maxLen) maxLen = len;
            }

            // Store first occurrence of this prefix sum
            if (!firstIndex.containsKey(sum)) {
                firstIndex.put(sum, i);
            }
        }

        return maxLen;
    }
}
