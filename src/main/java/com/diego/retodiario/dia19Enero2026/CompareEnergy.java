package com.diego.retodiario.dia19Enero2026;

public class CompareEnergy {
    /*
     * Reto día -- 19/Enero/2026
     * Se pasan dos datos a una función:
     * 1. Las calorías quemadas en un entrenamiento
     * 2. El número en watios-hora que utilizan nuestros dispositivos electrónicos en el mismo espacio de tiempo
     *
     * Se proporcionan los datos en calorías y en watts/h respectivamente.
     *
     * Se tiene que crear una función que devuelva "WORKOUT", "DEVICES" o "EQUALS", en función de donde se gaste más
     * energía.
     *
     * EQUIVALENCIAS:
     * - 1 caloría equivale a 4184 julios.
     * - 1 watts/h equivale a 3600 julios.
     * */

    public static void main(String[] args) {
        // VARIABLES
        int calorias = 0;
        int wattsHour = 0;
        try {
            if (args.length != 2)
                throw new Exception("Se deben pasar dos números por parámetro al programa.");

            calorias = Integer.parseInt(args[0]);
            wattsHour = Integer.parseInt(args[1]);

            // PROCESAMIENTO
            if (calorias < 0 || wattsHour < 0)
                throw new Exception("Ni las calorías gastadas ni los wattios por hora del dispositivo pueden ser menor a 0.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // SALIDA
        System.out.println("Datos proporcionados:\nWORKOUT --> " + calorias + "\nDEVICES --> " + wattsHour);
        System.out.println("Mayor energía usada: " + compareEnergy(calorias, wattsHour));
    }

    private static String compareEnergy(int caloriesBurned, int wattsHourUsed) {
        // Constantes
        int CONVERSOR_CALORIAS = 4184;
        int CONVERSOR_WATTSHOUR = 3600;

        // Variables
        String msg = "";

        // Procesamiento
        caloriesBurned = caloriesBurned * CONVERSOR_CALORIAS;
        wattsHourUsed = wattsHourUsed * CONVERSOR_WATTSHOUR;

        if (caloriesBurned < wattsHourUsed){
            msg = "DEVICES";
        } else if (caloriesBurned == wattsHourUsed) {
            msg = "EQUALS";
        } else {
            msg = "WORKOUT";
        }

        // Salida
        return msg;
    }
}
