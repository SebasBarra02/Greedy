import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Actividad implements Comparable<Actividad> {
        int inicio;
        int fin;

        public Actividad(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public int compareTo(Actividad otra) {
            return this.fin - otra.fin;
        }
    }

    public static int maxActividades(Actividad[] actividades) {
        Arrays.sort(actividades);
        int count = 1;
        int finPrevio = actividades[0].fin;

        for (int i = 1; i < actividades.length; i++) {
            if (actividades[i].inicio >= finPrevio) {
                count++;
                finPrevio = actividades[i].fin;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Actividad[] actividades = new Actividad[n];

        for (int i = 0; i < n; i++) {
            int inicio = scanner.nextInt();
            int fin = scanner.nextInt();
            actividades[i] = new Actividad(inicio, fin);
        }

        System.out.println(maxActividades(actividades));
    }
}
