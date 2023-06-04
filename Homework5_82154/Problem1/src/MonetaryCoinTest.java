import javax.swing.*;

public class MonetaryCoinTest {
    public static int computeSum(MonetaryCoin[] coins){
        int sum = 0;
        for (MonetaryCoin c : coins){
            sum += c.getValue();
        }
        return sum;
    }

    public static void printCoins(MonetaryCoin[] coins){
        for (MonetaryCoin c : coins){
            System.out.println(c);
        }
    }

    public static void flipCoins(MonetaryCoin[] coins){
        for (MonetaryCoin c : coins){
            c.flip();
        }
    }

    public static void main(String[] args) {
        MonetaryCoin[] coins = new MonetaryCoin[4];
        coins[0] = new MonetaryCoin(20, Face.HEAD);
        coins[1] = new MonetaryCoin(10, Face.HEAD);
        coins[2] = new MonetaryCoin(50, Face.TAIL);
        coins[3] = new MonetaryCoin(20, Face.TAIL);

        System.out.println("Sum of the values of the coins is: " + computeSum(coins));

        System.out.println("Before flip:");
        printCoins(coins);
        flipCoins(coins);
        System.out.println("After flip:");
        printCoins(coins);
    }
}
