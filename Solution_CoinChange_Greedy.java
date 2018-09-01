import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution_CoinChange_Greedy {
    public static List<Integer> coinChange(int[] coins, int amount) {
        // check for edge cases
        if(coins ==null || amount <=0 || coins.length==0) return null;
        // List which we will return
        ArrayList<Integer> toReturn = new ArrayList<>();
        // The quotient
        int q=0;
        // The remainder
        int r=0;
        // Adding biggest denominations first greedily.
        q=amount/25; r= amount % 25;
            toReturn.add(q);
            q= r/10; r=r%10;
            toReturn.add(q);
            q = r / 5; r= r % 5;
            toReturn.add(q);
            toReturn.add(r);
            return toReturn;
        }

    public static void main(String[] args){
        // The given coin denominations
        int[] coins={25, 10, 5, 1};
        // The given amount.
        int amount = 83;
        System.out.println(coinChange(coins , amount).toString()  );
    }
}
