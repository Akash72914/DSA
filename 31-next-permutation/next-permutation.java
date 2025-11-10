class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
            return;
        }

        for(int i=n-1; i>=idx; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        int left = idx + 1;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}