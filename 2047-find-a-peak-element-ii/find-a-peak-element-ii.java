class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> temp = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int top = (i == 0) ? -1 : mat[i-1][j];
                int bottom = (i == n-1) ? -1 : mat[i+1][j];
                int left = (j == 0) ? -1 : mat[i][j-1];
                int right = (j == m-1) ? -1 : mat[i][j+1];

                if(mat[i][j] > top &&
                   mat[i][j] > bottom &&
                   mat[i][j] > left &&
                   mat[i][j] > right) {

                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}