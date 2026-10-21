import java.util.Scanner;

public class Temperaturas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double[] temperaturas = new double[30];
        int[] dias = new int[30];

        // Registrar las temperaturas de septiembre.
        for (int i = 0; i < temperaturas.length; i++) {
            dias[i] = i + 1;

            System.out.print("Temperatura del " + dias[i] + " de septiembre: ");
            temperaturas[i] = entrada.nextDouble();
        }

        ordenarBurbuja(temperaturas, dias, true);

        System.out.println("\nTemperaturas en orden ascendente:");
        mostrarTemperaturas(temperaturas, dias);

        ordenarBurbuja(temperaturas, dias, false);

        System.out.println("\nTemperaturas en orden descendente:");
        mostrarTemperaturas(temperaturas, dias);

        entrada.close();
    }

    public static void ordenarBurbuja(double[] temperaturas,
                                      int[] dias,
                                      boolean ascendente) {
        for (int i = 0; i < temperaturas.length - 1; i++) {
            boolean huboCambio = false;

            for (int j = 0; j < temperaturas.length - 1 - i; j++) {
                boolean intercambiar;

                if (ascendente) {
                    intercambiar = temperaturas[j] > temperaturas[j + 1];
                } else {
                    intercambiar = temperaturas[j] < temperaturas[j + 1];
                }

                if (intercambiar) {
                    // Intercambiar temperaturas.
                    double temperaturaAuxiliar = temperaturas[j];
                    temperaturas[j] = temperaturas[j + 1];
                    temperaturas[j + 1] = temperaturaAuxiliar;

                    // Intercambiar sus fechas correspondientes.
                    int diaAuxiliar = dias[j];
                    dias[j] = dias[j + 1];
                    dias[j + 1] = diaAuxiliar;

                    huboCambio = true;
                }
            }

            // Terminar si los datos ya estan ordenados.
            if (!huboCambio) {
                break;
            }
        }
    }

    public static void mostrarTemperaturas(double[] temperaturas, int[] dias) {
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println(temperaturas[i] + ", " + dias[i] + " sep");
        }
    }
}