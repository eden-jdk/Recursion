package T3_EstructurasNoLineales.Recursividad;

public class MedicionTiempo {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        // Bloque de código a medir (ejemplo: suma iterativa de 1 millón de números)
        long suma = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            suma += i;
        }

        long fin = System.nanoTime();
        long duracionNano = fin - inicio;
        double duracionMili = duracionNano / 1_000_000.0;

        System.out.println("Resultado: " + suma);
        System.out.println("Tiempo en nanosegundos: " + duracionNano + " ns");
        System.out.println("Tiempo en milisegundos: " + duracionMili + " ms");
    }
}