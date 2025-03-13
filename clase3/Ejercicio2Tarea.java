package clase3;

public class Ejercicio2Tarea {
    
    public static void main(String[] args) {

        /*
         * Ejercicio 2: Elaborar un programa que lea 30 números y que imprima el número mayor, el menor y el número de veces que see repiten ambos.
         */

        // Arreglo de enteros
        int[] a = new int[30];

        // Recorrer el arreglo
        // a.length -> Obtiene la longitud o tamaño del arreglo 
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (100 - 0)) + 0;
        }

        // Recorrer el arreglo
        // a.length -> Obtiene la longitud o tamaño del arreglo 
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }

        // Recorrer el arreglo
        // a.length -> Obtiene la longitud o tamaño del arreglo 
        int mayor = a[0], menor = a[0], vecesMayor = 0, vecesMenor = 0, posMayor = 0, posMenor = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > mayor) {
                mayor = a[i];
            }
            if (a[i] < menor) {
                menor = a[i];
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == mayor) {
                vecesMayor++;
                posMayor = i;
            }
            if (a[i] == menor) {
                vecesMenor++;
                posMenor = i;
            }
        }

        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);
        System.out.println("El número de veces que está el número mayor es: " + vecesMayor + " y se encuentra en la posición: " + posMayor);
        System.out.println("El número de veces que está el número menor es: " + vecesMenor + " y se encuentra en la posición: " + posMenor);
    }
}
