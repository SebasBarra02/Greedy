package CoinChange.greedy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            int[] coins = {50, 25, 10, 5, 1};
            int ways = countChangeWays(amount, coins);
            System.out.println(ways);
        }

        scanner.close();
    }

    public static int countChangeWays(int amount, int[] coins) {
        int ways = 0;
        int index = 0;

        while (amount > 0 && index < coins.length) {
            if (coins[index] <= amount) {
                int count = amount / coins[index];
                ways += count;
                amount -= count * coins[index];
            }
            index++;
        }

        return ways;
    }
}
