package com.diego.retodiario.dia16Enero2026;

public class HipotenusaChecker {
    /*
    * Reto día -- 16/Enero/2026
    * Se proporcionan los dos lados catetos de un triángulo rectángulo.
    * Los catetos son numeros enteros.
    * Se valora si la hipotenusa es también un número entero o un decimal.
    * */

    public static void main(String[] args){
        try{
            if (args.length != 2) throw new Exception("Se deben introducir dos números.");
            // VARIABLES
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            System.out.println("Números:\n"+num1+"\n"+num2+"\n"+"La hipotenusa es número entero: " + esHipotenusaEntera(num1, num2));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    static boolean esHipotenusaEntera(int lado1, int lado2){
        double hipotenusa = Math.sqrt((lado1*lado1) + (lado2*lado2)); // La hipotenusa es la raiz cuadrada de la suma de los cuadrados de los otros dos lados.
        return hipotenusa % 1 == 0; // Si un número dividido entre 1 da decimales es que no es Entero.
    }
}
