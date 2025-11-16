class Solution {
    int maxLength(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int maxi = 0;

        for (int i=0; i<n; i++) {

            sum += arr[i];

            if(sum == 0) {
                maxi = i + 1;
            } else {
                if(map.get(sum) != null) {
                    maxi = Math.max(maxi, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return maxi;
    }
}