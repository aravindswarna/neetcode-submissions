class NumMatrix {
    int[][] sm;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        sm = new int[r+1][c+1];
        for(int i = 0; i<r; i++){
            int s = 0;
            for(int j = 0; j<c; j++){
                s+=matrix[i][j];
                sm[i+1][j+1] = s + sm[i][j+1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;

        return sm[row2][col2] - (sm[row1-1][col2] + sm[row2][col1-1]) + sm[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */