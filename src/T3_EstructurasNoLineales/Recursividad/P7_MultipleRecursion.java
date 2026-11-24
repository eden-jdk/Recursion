package T3_EstructurasNoLineales.Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P7_MultipleRecursion {
    int k;
    int m;
    List<String> universe;
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

    // Code Fragment 5.13 (Goodrich, pag. 213): Multiple Recursion - PuzzleSolve
    public static void puzzleSolve(int k, List<String> s, List<String> u) {
        for (int i = 0; i < u.size(); i++) {
            String e = u.remove(i); // Quita el elemento e de U
            s.add(e);               // Agrega e al final de S

            if (k == 1) {
                System.out.println("Solucion generada: " + s);
            } else {
                puzzleSolve(k - 1, s, u); // Llamada recursiva multiple dentro del ciclo
            }

            s.remove(s.size() - 1); // Backtracking: quita e de S
            u.add(i, e);            // Restaura e en su posicion original en U
        }
    }

    public void leerDatos() {
        k = reader.nextInt(); // Longitud de la combinacion deseada
        m = reader.nextInt(); // Cantidad de elementos en el conjunto universo U
        universe = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            universe.add(reader.next());
        }
    }

    public void resuelve() {
        List<String> sequence = new ArrayList<>();
        puzzleSolve(k, sequence, universe);
    }

    public static void main(String[] args) {
        P7_MultipleRecursion id = new P7_MultipleRecursion();
        id.leerDatos();
        id.resuelve();
    }
}