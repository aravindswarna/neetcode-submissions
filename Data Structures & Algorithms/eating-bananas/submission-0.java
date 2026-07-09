class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;

        for(int ele: piles){
            r = Math.max(r, ele);
        }
        int ans = 0;
        while(l <= r){
            int m = l + (r-l)/2;
            if(isValidAns(piles, m, h)){
                ans = m;
                r = m - 1;
            } else {
                l = m +1;
            }
        }
        return ans;
    }

    boolean isValidAns(int[] piles, int k, int h){
        int kSum = 0;
        for(int ele: piles){
            if(ele % k == 0){
                kSum += (ele/k);
            } else {
                kSum += (ele/k) + 1;
            }

            if(kSum > h) return false;
        }
        return true;

    }
}
