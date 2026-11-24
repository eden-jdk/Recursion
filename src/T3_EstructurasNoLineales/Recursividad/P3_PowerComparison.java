package T3_EstructurasNoLineales.Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3_PowerComparison {
    double x;
    int n;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    String line = b.readLine();
                    if (line == null) return null;
                    s = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    // Code Fragment 5.8: Trivial recursion (BAD)
    public static double powerBad(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * powerBad(x, n - 1);
    }

    // Code Fragment 5.9: Repeated squaring (GOOD)
    public static double powerGood(double x, int n) {
        if (n == 0)
            return 1;
        else {
            double partial = powerGood(x, n / 2);
            double result = partial * partial;
            if (n % 2 == 1)
                result *= x;
            return result;
        }
    }

    public void leerDatos() {
        x = reader.nextDouble();
        n = reader.nextInt();
    }

    public void resuelve() {
        // Medicion algoritmo BAD
        long inicioBad = System.nanoTime();
        double resBad = powerBad(x, n);
        long finBad = System.nanoTime();
        double tiempoBadMs = (finBad - inicioBad) / 1_000_000.0;

        // Medicion algoritmo GOOD
        long inicioGood = System.nanoTime();
        double resGood = powerGood(x, n);
        long finGood = System.nanoTime();
        double tiempoGoodMs = (finGood - inicioGood) / 1_000_000.0;

        System.out.println("Entrada: x = " + x + ", N = " + n);
        System.out.println("Resultado Bad:  " + resBad + " | Tiempo Bad:  " + tiempoBadMs + " ms");
        System.out.println("Resultado Good: " + resGood + " | Tiempo Good: " + tiempoGoodMs + " ms");
    }

    public static void main(String[] args) {
        P3_PowerComparison id = new P3_PowerComparison();
        id.leerDatos();
        id.resuelve();
    }
}