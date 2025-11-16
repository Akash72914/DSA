import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            //avoiding duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    //skip duplicates on left pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    //skip duplicates on right pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }

                else if (sum < 0) {
                    left++;
                }

                else {
                    right--;
                }
            }
        }

        return res;
    }
}
