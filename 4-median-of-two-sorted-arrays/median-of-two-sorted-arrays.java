class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        List<Integer> temp = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < m && j < n) {

            if(nums1[i] <= nums2[j]) {
                temp.add(nums1[i++]);
            } else {
                temp.add(nums2[j++]);
            }
        }

        while(i < m) {
            temp.add(nums1[i++]);
        }

        while(j < n) {
            temp.add(nums2[j++]);
        }

        int l = temp.size();

        if(l % 2 == 1) {
            return temp.get(l / 2);
        }

        return (temp.get(l/2) + temp.get((l/2)-1)) / 2.0;
    }
}