package clase3;

public class Ejercicio1Tarea {

    public static void main(String[] args) {

        /*
         * Ejercicio 1
         * Obtener dos arreglos tal que sus elementos sean los números pares e impares
         * del 1 al 10 del arreglo A de 10 elementos
         */

        // Arreglo de enteros
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Arreglo de enteros pares
        int[] pares = new int[a.length];
        // Arreglo de enteros impares
        int[] impares = new int[a.length];

        // Arreglo de enteros pares
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                pares[i] = a[i];
                System.out.println("El número par es: " + pares[i]);
            } 
        }

        // Arreglo de enteros impares
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                impares[i] = a[i];
                System.out.println("El número impar es: " + impares[i]);
            }
        }

        System.out.println();

        int contadorPares = 0, contadorImpares = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                contadorPares ++ ;
            } else {
                contadorImpares ++ ;
            }
        }

        int[] numerosPares = new int[contadorPares];
        int[] numerosImpares = new int[contadorImpares];

        int pares2 = 0, impares2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                numerosPares[pares2] = a[i];
                pares2 ++;
            } else {
                numerosImpares[impares2] = a[i];
                impares2 ++;
            }
        }

        System.out.println("Los números pares son: ");
        for (int i = 0; i < numerosPares.length; i++) {
            System.out.println(numerosPares[i] + " ");
        }

        System.out.println();

        System.out.println("Los números impares son: ");
        for (int i = 0; i < numerosImpares.length; i++) {
            System.out.println(numerosImpares[i] + " ");
        }

    }

}
