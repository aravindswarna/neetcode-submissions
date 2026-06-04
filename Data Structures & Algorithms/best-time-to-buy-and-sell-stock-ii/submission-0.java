class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currStock = prices[0];
        for(int i = 1; i<prices.length; i++){

            if(prices[i-1] > prices[i]){
                int currProfit = prices[i - 1] - currStock;
                profit = profit+currProfit;
                currStock = prices[i];
            }

        }
        if(currStock < prices[prices.length-1]){
            profit += (prices[prices.length-1]-currStock);
        }
        return profit;
    }
}