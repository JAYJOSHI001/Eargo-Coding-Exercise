import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution_CoinChange_DP {
    public static List<Integer> coinChange(int[] coins, int amount) {
        // check for edge cases
        if(coins ==null || amount <=0 || coins.length==0) return null;
        // dp array for min number of coins
        int[] dp = new int[amount+1];
        // thought java default all int array values to 0 but still to make base condition clear
        dp[0]=0;
        /*dp array for coins that make up min number of coins
        * Filled the dp2 list with new arraylists to ensure size of dp2 list during runtime
        */
        ArrayList<ArrayList<Integer>> dp2 = new ArrayList<ArrayList<Integer> >(Collections.nCopies(amount + 1 , new ArrayList<Integer>()));
       // Again adding an empty arraylist at 0th index for base condition
        dp2.add(0, new ArrayList<Integer>());
        // Iterativly find optiman change of coins for amount 1 to given amount
        for(int i=1; i<=amount ; i++){
            dp[i]=amount+1;

            for(int coin : coins){
                if(i >= coin){
                    if(dp[i]> dp[i-coin] + 1){

                        dp[i] = dp[i-coin] + 1; //dp2.ensureCapacity(amount + 1);
                        dp2.add( i, new ArrayList<Integer> (dp2.get(i-coin)) )  ;
                        dp2.get(i).add(coin);
                    }

                }
            }
        }

        // Convert the computed list of coins to the problem specification.
        ArrayList<Integer> toReturn = new ArrayList<>();
        // If no solution is present. Although since we have a 1 denomination this case will not occur.
        if((dp[amount] > amount ? -1 : dp[amount]) == -1) {
            return toReturn;
        }
        // When a solution exists.
        else {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int coin : dp2.get(amount)){
                map.put(coin, map.getOrDefault(coin,0) + 1 );
            }
            toReturn.add(map.getOrDefault(25, 0));
            toReturn.add(map.getOrDefault(10 , 0));
            toReturn.add(map.getOrDefault(5 , 0));
            toReturn.add(map.getOrDefault(1 , 0));
            // Return the list in required format.
            return toReturn;
        }
    }

    public static void main(String[] args){
        // The given coin denominations
        int[] coins={25, 10, 5, 1};
        // The given amount
        int amount = 83;
        System.out.println(coinChange(coins , amount).toString()  );
    }
}
