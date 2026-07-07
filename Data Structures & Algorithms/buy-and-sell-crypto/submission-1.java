class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            int currentPrice = prices[i];

            int profit = currentPrice - minPrice;
            maxProfit = Math.max(maxProfit, profit);

            minPrice = Math.min(minPrice, currentPrice); 
        }
        return maxProfit;
    }
}
