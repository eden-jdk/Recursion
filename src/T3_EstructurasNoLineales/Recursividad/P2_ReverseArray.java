package T3_EstructurasNoLineales.Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2_ReverseArray {
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

    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);
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
        System.out.println("Antes:   " + Arrays.toString(data));
        reverseArray(data, 0, n - 1);
        System.out.println("Despues: " + Arrays.toString(data));
    }

    public static void main(String[] args) {
        P2_ReverseArray id = new P2_ReverseArray();
        id.leerDatos();
        id.resuelve();
    }
}