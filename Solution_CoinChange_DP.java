import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution_CoinChange_DP {
    public static List<Integer> coinChange(int[] coins, int amount) {
        if(coins ==null || amount <=0 || coins.length==0) return null;
        int[] dp = new int[amount+1]; dp[0]=0; // thought java default all int array values to 0
        ArrayList<ArrayList<Integer>> dp2 = new ArrayList<ArrayList<Integer> >(Collections.nCopies(amount + 1 , new ArrayList<Integer>()));
        dp2.add(0, new ArrayList<Integer>());
        for(int i=1; i<=amount ; i++){
            dp[i]=amount+1;

            for(int coin : coins){
                if(i >= coin){
                    if(dp[i]> dp[i-coin] + 1){

                        dp[i] = dp[i-coin] + 1; //dp2.ensureCapacity(amount + 1);
                        dp2.add( i, new ArrayList<Integer> (dp2.get(i-coin)) )  ;
                        dp2.get(i).add(coin);
                    }

                    //  dp[i] = Math.min(dp[i] , dp[i-coin]+1);
                }
            }



        }

        ArrayList<Integer> toReturn = new ArrayList<>();
        if((dp[amount] > amount ? -1 : dp[amount]) == -1) {
            //System.out.println(" No Soulution");
            return toReturn;

        }else {
            //System.out.println(dp2.get(amount).toString());
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int coin : dp2.get(amount)){
                map.put(coin, map.getOrDefault(coin,0) + 1 );

            }
            toReturn.add(map.getOrDefault(25, 0));
            toReturn.add(map.getOrDefault(10 , 0));
            toReturn.add(map.getOrDefault(5 , 0));
            toReturn.add(map.getOrDefault(1 , 0));
            return toReturn;
        }
       // return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args){

        int[] coins={25, 10, 5, 1};
        int amount = 83;
        System.out.println(coinChange(coins , amount).toString()  );

    }

}
