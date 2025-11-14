class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;

        for(int i=0; i<=n-1; i++) {
            if(count1 == 0 && nums[i] != e2) {
                count1 = 1;
                e1 = nums[i];
            } else if(count2 == 0 && nums[i] != e1) {
                count2 = 1;
                e2 = nums[i];
            } else if(e1 == nums[i]) {
                count1++;
            } else if(e2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        for(int i=0; i<n; i++) {
            if(e1 == nums[i]) {
                count1++;
            }
            if(e2 == nums[i]) {
                count2++;
            }
        }

        int mini = (n/3) + 1;
        
        if(count1 >= mini) {
            res.add(e1);
        }
        if(count2 >= mini) {
            res.add(e2);
        }

        return res;
    }
}