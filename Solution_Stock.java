import java.util.HashMap;

public class Solution_Stock {


    public static HashMap<String, Integer> findBestDays(int[] prices) {
      // Check edge cases
        if(prices ==null || prices.length==0) {
            return null;
        }
        HashMap<String, Integer> daysToBuySell = new HashMap<>();
        int maxProfit=0;
        int minPrice=prices[0];
        int sellAt=0;
        int buyAt=0;
        for(int i=0 ; i<prices.length ; i++){
            if(prices[i]-minPrice>maxProfit){
                maxProfit= prices[i]-minPrice;
                sellAt=i;
            }
            if(minPrice > prices[i]){
                minPrice=prices[i];
                buyAt=i;
            }
        }
        // Add the days to HashMap ( We add 1 to convert index to day)
        daysToBuySell.put("buying day" , buyAt + 1);
        daysToBuySell.put("selling day",sellAt + 1);
        return daysToBuySell;
    }

    public static void main(String[] args){
       // input stock prices;
        int[] prices= {3,8,8,55,38,1,7,42,54,53};
        HashMap<String, Integer> days = findBestDays(prices);

        for(String dayType : days.keySet()){
            System.out.println(dayType + "\t" + days.get(dayType));
        }

        return;
    }
}
