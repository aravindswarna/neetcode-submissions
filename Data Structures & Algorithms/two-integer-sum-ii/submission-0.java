class Solution {
    public int[] twoSum(int[] num, int k) {
        
        int p1 = 0;
        int p2 = num.length - 1;

        while(p1<p2){
            if(num[p1] + num[p2] == k){
                return new int[]{p1+1, p2+1};
            } else if(num[p1] + num[p2] < k){
                p1++;
            } else {
                p2--;
            }
        }
        return new int[]{};
    }
}
