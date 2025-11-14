class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();

        for(int row=1; row<=n; row++) {
            List<Integer> temp = new ArrayList<>();
            for(int col=1; col<=row; col++) {
                temp.add(nCr(row-1, col-1));
            }
            ans.add(temp);
        }

        return ans;
    }

    private int nCr(int n, int r) {
        int result = 1;

        for(int i=0; i<r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }
}