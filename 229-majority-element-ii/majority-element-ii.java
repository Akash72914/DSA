class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(res.size() == 0 || res.get(0) != nums[i]) {
                int count = 0;
                for(int j=0; j<=n-1; j++) {
                    if(nums[j] == nums[i]) {
                        count++;
                    }
                }
                if(count > n/3) {
                    res.add(nums[i]);
                }
            }
            if(res.size() == 2) {
                break;
            }
        }

        return res;
    }
}