package clase3;

public class CreacionArreglos {

    public static void main(String[] args) {
        
        // Arreglo de enteros
        int[] a = { 3, 6, 5, 10, 20, 1, 4, 9 };

        // Recorrer el arreglo
        // a.length -> Obtiene la longitud o tamaño del arreglo 
        for (int i = 0; i < a.length; i++) {
            System.out.println("a["+ i + "] = " + a[i]);
        }
    }

}
