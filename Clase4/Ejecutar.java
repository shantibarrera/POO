package Clase4;

public class Ejecutar {
    
    public static void main(String[] args) {

        // Crear un objeto de la clase Vehiculo

        // Forma 1
        Vehiculo objVehiculo1 = new Vehiculo("Toyota", "Blanco", 4500.0, "TS3456WE", 2.3, "180 HP");

        // Forma 2
        Vehiculo objVehiculo2;
        objVehiculo2 = new Vehiculo("Ferrari", "Rojo", 5000.0, "SEWE567UY", 1.8, "450 HP");

        // Mostrar la marca de vehiculo del objeto objVehiculo 
        System.out.println(objVehiculo1.getMarca());
        
        // Se va a modificar la marca de vehiculo del objeto objVehiculo1
        objVehiculo1.setMarca("Chevrolet");

        // Mostrar todo el objeto
        System.out.println(objVehiculo1.toString());
        System.out.println(objVehiculo2);

        // Llamar al metodo acelerar
        objVehiculo1.acelerar();

        // Llamar al metodo frenar
        System.out.println(objVehiculo2.getMarca());
        objVehiculo2.frenar();

    }
}
