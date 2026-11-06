class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            int currentPrice = prices[i] - minPrice;
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, currentPrice);
        }
        return maxProfit;
    }
}
