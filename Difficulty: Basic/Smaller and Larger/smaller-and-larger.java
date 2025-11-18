class Solution {
    int[] getMoreAndLess(int[] arr, int target) {
        int smaller = 0;
        int larger = 0;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] <= target) {
                smaller++;
            }
            if(arr[i] >= target) {
                larger++;
            }
        }
        return new int[]{smaller, larger};
    }
}
