class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int l = 0;
        int r = matrix.length - 1;
        int ans = 0;
        while(l <= r){
            int m = l + (r - l)/2;
            if(matrix[m][0] <= target){ //10 <= 9
                ans = m;
                l = m + 1;
            } else {
                r = m -1;
            }
        }

        l = 0;
        r = matrix[ans].length - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(matrix[ans][m] == target){
                return true;
            } else if(matrix[ans][m] < target) {
                l = m + 1;
            } else {
                r =  m - 1;
            }

        }
        return false;
    }
}
