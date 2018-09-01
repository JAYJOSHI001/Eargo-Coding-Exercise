import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution_CoinChange_Greedy {
    public static List<Integer> coinChange(int[] coins, int amount) {
        if(coins ==null || amount <=0 || coins.length==0) return null;
        ArrayList<Integer> toReturn = new ArrayList<>();
        int q=0; int r=0;
        q=amount/25; r= amount % 25;
            toReturn.add(q);
            q= r/10; r=r%10;
            toReturn.add(q);
            q = r / 5; r= r % 5;
            toReturn.add(q);
            toReturn.add(r);
            return toReturn;
        }
       // return dp[amount] > amount ? -1 : dp[amount];


    public static void main(String[] args){

        int[] coins={25, 10, 5, 1};
        int amount = 83;
        System.out.println(coinChange(coins , amount).toString()  );

    }

}
