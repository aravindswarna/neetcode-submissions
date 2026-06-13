class Solution {
    public int maxProfit(int[] prices) {
        //[10,1,5,6,6,1]

        int l = prices[0];
        int profit = 0;
        for(int ele: prices){
            if(ele <= l){
                l = ele;
            } else {
                profit = Math.max(profit, ele - l);
            }

        }
        return profit;
    }
}
