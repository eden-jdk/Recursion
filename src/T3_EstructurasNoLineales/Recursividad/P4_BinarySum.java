package T3_EstructurasNoLineales.Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4_BinarySum {
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

    public static int binarySum(int[] data, int low, int high) {
        if (low > high)
            return 0;
        else if (low == high)
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    public void leerDatos() {
        n = reader.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        int resultado = binarySum(data, 0, n - 1);
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        P4_BinarySum id = new P4_BinarySum();
        id.leerDatos();
        id.resuelve();
    }
}