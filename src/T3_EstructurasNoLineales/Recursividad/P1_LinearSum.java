package T3_EstructurasNoLineales.Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1_LinearSum {
    int n;
    int[] data;
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

    public static int linearSum(int[] data, int n) {
        if (n == 0)
            return 0;
        else
            return linearSum(data, n - 1) + data[n - 1];
    }

    public void leerDatos() {
        n = reader.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        int resultado = linearSum(data, n);
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        P1_LinearSum id = new P1_LinearSum();
        id.leerDatos();
        id.resuelve();
    }
}