/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

//[1,2,3,4,5]
class Solution {
    public int findInMountainArray(int target, MountainArray mA) {
        int l = 0;
        int r = mA.length() - 1;
        int n = mA.length() - 1;
        int ans = 0;
        while(l <= r){
            int m = l + (r-l)/2;
            if(m < n && mA.get(m) > mA.get(m + 1)){
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
        int bin1 = bin(target, mA, ans);
            System.out.println(bin1);

        return (bin1 != -1?bin1:binR(target, mA, ans));
    }


    public int bin(int target, MountainArray mA, int b){

        int l = 0;
        int r = b;

        if(target <= mA.get(b) && mA.get(l)<= target) {
            while(l <= r){
                int m = l + (r - l)/2;
                if(mA.get(m) == target){
                    return m;
                } else if(mA.get(m) < target){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            
        } 
        return -1;
    }
    public int binR(int target, MountainArray mA, int b){
        int n = mA.length() - 1;
        int l = b+1;
        int r = n;
        if(target <= mA.get(b+1) && mA.get(n)<= target) {
            while(l <= r){
                int m = l + (r - l)/2;
                if(mA.get(m) == target){
                    return m;
                } else if(mA.get(m) < target){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }  return -1;

    }

}