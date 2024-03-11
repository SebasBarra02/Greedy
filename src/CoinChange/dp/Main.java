package CoinChange.dp;

import java.util.*;

public class Main {
    static int[] monedas = {1, 5, 10, 25, 50};
    static int[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int cantidad = scanner.nextInt();
            memo = new int[cantidad + 1][monedas.length];
            int formas = contarFormasCambio(cantidad, 0);
            System.out.println(formas);
        }
        scanner.close();
    }

    public static int contarFormasCambio(int cantidad, int indiceMoneda) {
        if (cantidad <= 0) return 1;

        if (indiceMoneda == monedas.length) return 0;

        if (memo[cantidad][indiceMoneda] != 0) return memo[cantidad][indiceMoneda];

        int incluirMoneda = 0, excluirMoneda = 0;

        if (cantidad - monedas[indiceMoneda] >= 0) {
            incluirMoneda = contarFormasCambio(cantidad - monedas[indiceMoneda], indiceMoneda);
        }

        excluirMoneda = contarFormasCambio(cantidad, indiceMoneda + 1);

        memo[cantidad][indiceMoneda] = incluirMoneda + excluirMoneda;
        return memo[cantidad][indiceMoneda];
    }
}

