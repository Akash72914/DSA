class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        //check if first row has any zero
        for(int j=0; j<n; j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        //check if first col has any zero
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        //using first row and col as markers for other rows and cols
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;    //mark row i
                    matrix[0][j] = 0;    //mark col j
                }
            }
        }

        //zero cells based on markers(except first row and first col)
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //zero first row if needed
        if(firstRowZero) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }

        //zero first col if needed
        if(firstColZero) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}