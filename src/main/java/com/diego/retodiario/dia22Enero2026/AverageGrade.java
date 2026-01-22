package com.diego.retodiario.dia22Enero2026;

import java.util.ArrayList;
import java.util.Arrays;

public class AverageGrade {
    /*
     * Reto día -- 22/Enero/2026
     * Se recibe un array de notas de exámenes. Las notas van de 0 a 100 y en función de la media se asigna un valor en
     * forma de letra.
     * Las letras que se asignan son las siguientes:
     * 97-100	"A+"
     * 93-96	"A"
     * 90-92	"A−"
     * 87-89	"B+"
     * 83-86	"B"
     * 80-82	"B-"
     * 77-79	"C+"
     * 73–76	"C"
     * 70-72	"C-"
     * 67-69	"D+"
     * 63-66	"D"
     * 60–62	"D-"
     * below 60	"F"
     * */

    static void main(String[] args) {
        try{
            if (args.length < 1)
                throw new Exception("Se deben introducir notas para poder calcular la media.");

            // VARIABLES
            int[] notas = notasNumericas(args);
            int media = 0;
            String calificacion = "";

            // PROCESAMIENTO
            for (int i = 0; i< notas.length; i++){
                if (notas[i] < 0 || notas[i] > 100)
                    throw new Exception("Una de las notas es menor a 0 o mayor a 100");
            }
            media = calcularMedia(notas);

            // SALIDA
            System.out.println("Nota media --> " + media + "\nCalificación --> " + getAverageGrades(media));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static String getAverageGrades(int score){
        String grade = " ";

        switch (score / 10) {
            case 10, 9 -> {
                if (score >= 97) grade = "A+";
                else if (score >= 93) grade = "A";
                else grade = "A-";
            }
            case 8 -> {
                if (score >= 87) grade = "B+";
                else if (score >= 83) grade = "B";
                else grade = "B-";
            }
            case 7 -> {
                if (score >= 77) grade = "C+";
                else if (score >= 73) grade = "C";
                else grade = "C-";
            }
            case 6 -> {
                if (score >= 67) grade = "D+";
                else if (score >= 63) grade = "D";
                else grade = "D-";
            }
            default -> grade = "F";
        }

        return grade;
    }

    private static int calcularMedia(int[] scores){
        int sumaNotas = 0;
        for (int i = 0; i < scores.length; i++){
            sumaNotas += scores[i];
        }

        return (int)(sumaNotas / scores.length);
    }

    private static int[] notasNumericas(String[] notas){
        ArrayList<Integer> listaNotas = new ArrayList<>();
        int[] arrayNotas;
        int nota = 0;

        for (int i = 0; i < notas.length; i++){
            nota = Integer.parseInt(notas[i]);
            listaNotas.add(nota);
        }

        arrayNotas = new int[listaNotas.toArray().length];
        for (int i = 0; i < arrayNotas.length; i++){
            arrayNotas[i] = listaNotas.get(i);
        }

        return arrayNotas;
    }
}
