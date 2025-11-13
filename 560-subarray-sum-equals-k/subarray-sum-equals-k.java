class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prefixSum = 0;

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);   //Base case -> one way to have sum = 0 before we start

        for(int i=0; i<n; i++) {
            prefixSum = prefixSum + nums[i];
            int difference = prefixSum - k;

            //check if there exists a previous prefix sum equals to difference
            if(map.containsKey(difference)) {
                count = count + map.get(difference);
            }

            //update the frequency of the current prefix sum
            if(map.containsKey(prefixSum)) {
                map.put(prefixSum, map.get(prefixSum) + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }

        return count;
    }
}