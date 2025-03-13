package clase3;

public class Ejercicio3Tarea {
    
    public static void main(String[] args) {

        /*
        * Codifique un progrrama tal, que dado como entrada un arreglo unidimensional de eeneros y un número entero, determine
        * cúantas veces se encuentra este número dentro del arreglo
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

        System.out.println();

        // Número a buscar
        int buscar = (int) (Math.random() * (100 - 0)) + 0;
        System.out.println("El número a buscar es: " + buscar);

        System.out.println();

        // Recorrer el arreglo
        // a.length -> Obtiene la longitud o tamaño del arreglo 
        int veces = 0, posicion = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == buscar) {
                veces++;
                posicion = i;
            }
        }
        System.out.println("El número " + buscar + " se encuentra " + veces + " veces en la posición " + posicion);

    }
}
