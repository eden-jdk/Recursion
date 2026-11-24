package T3_EstructurasNoLineales.Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5_Fibonacci {
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
    }

    // Recursión binaria ineficiente O(2^n)
    public static long fibonacciBad(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacciBad(n - 2) + fibonacciBad(n - 1);
    }

    // Recursión lineal eficiente O(n)
    public static long[] fibonacciGood(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacciGood(n - 1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }

    public void leerDatos() {
        n = reader.nextInt();
    }

    public void resuelve() {
        long inicioBad = System.nanoTime();
        long resBad = fibonacciBad(n);
        long finBad = System.nanoTime();

        long inicioGood = System.nanoTime();
        long[] resGood = fibonacciGood(n);
        long finGood = System.nanoTime();

        System.out.println("n = " + n);
        System.out.println("fibonacciBad:  " + resBad + " (" + (finBad - inicioBad) / 1_000_000.0 + " ms)");
        System.out.println("fibonacciGood: " + resGood[0] + " (" + (finGood - inicioGood) / 1_000_000.0 + " ms)");
    }

    public static void main(String[] args) {
        P5_Fibonacci id = new P5_Fibonacci();
        id.leerDatos();
        id.resuelve();
    }
}