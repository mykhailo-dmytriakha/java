package _leetCode.arrays;

public class MaxProfit {
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int ret = maxProfit(prices);

        String out = String.valueOf(ret);
        System.out.println(out);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit +=(prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
