class Solution {
    
    public int maxProfit(int[] prices) {
        //keep maxprofit, profit and cost
        //loop through the array one time
        //on the way, if currentCost < cost, make set the cost to be currentCost
        //profit = currentCost - cost
        //if profit > maxProfit, make that the maxProfit
        
        int maxProfit = 0;
        int profit = 0;
        int cost = (int) Double.POSITIVE_INFINITY;
        
        for (int i = 0; i < prices.length; i++) {
            int current = prices[i];
            if (current < cost) {
                cost = current;
            } else {
                profit = current - cost;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;  
    }   
    
}
