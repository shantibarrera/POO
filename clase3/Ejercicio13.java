package clase3;

public class Ejercicio13 {
    
    public static void main(String[] args) {

        /*
         * Dado un arreglo A de n elementos, almacenar los elementos mayores y menores de la media,
         * almancenarlos en diferentes arreglos.
         */

        /*
         * Analisis: Crear un arreglo A de tamaño aleatorio y generar números aleatorios para que
         * sean almacenados en el arreglo. Posteriormente obtener la media de los elementos del
         * arreglo y comparar cada posición del arreglo para determinar si es mayor o menor a la media.
         */

        int n = (int) (Math.random() * (15 - 5  )) + 5;
        // Declarar Arreglo de entero
        int[] a = new int[n];

        // Generar números aleatorios para el arreglo entren 0 y 50.
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (50 - 0)) + 0;
        }

        // Recorrer el arreglo
        // a.length -> Obtiene la longitud o tamaño del arreglo 
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
            System.out.println();
        }                                          
        
        // Obtener la media de los elementos del arreglo
        // Declarar una variable para guardar la suma del arreglo
        int sumaArreglo = 0;
        for (int i = 0; i < a.length; i++) {
            sumaArreglo += a[i];
        }
        double media =  sumaArreglo / a.length;


        System.out.println("El tamaño del arreglo es: " + a.length);
        System.out.println("La suma del arreglo es: " + sumaArreglo);
        System.out.println("La media es: " + media);
        System.out.println();


        // Definir la cantidad de elementos que tiene el arreglo por encima y debajo de la media.

        int contadorMenorMedia = 0, contadorMayorMedia = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= media) {
                contadorMayorMedia ++ ;
            } else {
                contadorMenorMedia ++ ;
            }
        }

        // Creación de los arreglos que contendran los números mayores y menores de la media.
        int[] mayores = new int[contadorMayorMedia];
        int[] menores = new int[contadorMenorMedia];


        int posicionMayor = 0, posicionMenor = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= media) {
                mayores[posicionMayor] = a[i];
                posicionMayor ++;
            } else {
                menores[posicionMenor] = a[i];
                posicionMenor ++;
            }
        }

        // Mostrar el arreglo de mayores de la media
        System.out.println("Por encima de la media: ");
        for (int i = 0; i < mayores.length; i++) {
            System.out.println(mayores[i] + " ");
        }

        System.out.println();

        // Mostrar el arreglo de menores de la media
        System.out.println("Por debajo de la media: ");
        for (int i = 0; i < menores.length; i++) {
            System.out.println(menores[i] + " ");
        }
    }
}