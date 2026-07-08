class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        long n = x;
        int l = 1;
        int r = x/2;
        while(l <= r){
            int m = l + (r - l)/2;
            long rt = (long)m* (long)m;
            System.out.println(m+"--"+rt+"--"+n);

            if(rt == n){
                return m;
            } else if(rt > n){
                r = m - 1;
            } else {
                l = m+1;
            }
        }
        return r;
    }
}