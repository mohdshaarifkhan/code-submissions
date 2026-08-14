class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int n : prices){
            minPrice = Math.min(minPrice, n);
            int profit = n - minPrice;
            maxProfit = Math.max(maxProfit, profit);

        }
        return maxProfit;
    }
}
