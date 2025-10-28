class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int d = k % n;
        List<Integer> temp = new ArrayList<>();

        for(int i=n-d; i<n; i++) {
            temp.add(nums[i]);
        }

        for(int i=n-d-1; i>=0; i--) {
            nums[i+d] = nums[i];
        }

        for(int i=0; i<d; i++) {
            nums[i] = temp.get(i);
        }
    }
}