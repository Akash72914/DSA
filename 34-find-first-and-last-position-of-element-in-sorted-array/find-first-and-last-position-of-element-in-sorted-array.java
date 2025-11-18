class Solution {
    private int firstOccurance(int[] nums, int n, int target) {
        int left = 0;
        int right = n - 1;
        int first = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } 
            else if(nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return first;
    }

    private int lastOccurance(int[] nums, int n, int target) {
        int left = 0;
        int right = n - 1;
        int last = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } 
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int first = firstOccurance(nums, n, target);

        if(first == -1) {
            return new int[]{-1, -1};
        }

        int last = lastOccurance(nums, n, target);

        return new int[]{first, last};
    }
}