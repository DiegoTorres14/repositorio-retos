package com.diego.retodiario.dia20Enero2026;

public class ConsonantsVowels {
    /*
    * Reto día -- 20/Enero/2026
    * Se recibe una cadena de caracteres con un mensaje.
    * En el mensaje se tienen que colocar todas las consonantes como mayúscula y las
    * vocales como minúscula.
    * Los guiones se convierten en giones bajos.
    * */
    public static void main(String[] args) {
        try{
            if (args.length != 1)
                throw new Exception("Se debe introducir una y solo una cadena de caracteres");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Cadena introducida: " + args[0]);
        System.out.println("Resultado: " + toConsonantCase(args[0]));
    }

    private static String toConsonantCase(String s){
        StringBuilder stringBuilder = new StringBuilder();
        char caracter = ' ';

        for (int i = 0; i< s.length(); i++){
            caracter = s.toCharArray()[i];
            if (Character.isLetter(caracter)){
                if (isConsonant(caracter)){
                    caracter = Character.toUpperCase(caracter);
                } else {
                    caracter = Character.toLowerCase(caracter);
                }
            } else if (caracter == '-') {
                caracter = '_';
            }
            stringBuilder.append(caracter);
        }

        return stringBuilder.toString();
    }

    private static boolean isConsonant(char c){
        boolean isConsonant = false;

        if (Character.isLetter(c)){
            c = Character.toUpperCase(c);
            if (c == 'B' || c == 'C' ||c == 'D' ||c == 'F' ||c == 'G' ||c == 'H' ||c == 'J' ||c == 'K' ||c == 'L' ||
                    c == 'M' ||c == 'N' ||c == 'P' ||c == 'Q' ||c == 'R' ||c == 'S' ||c == 'T' ||c == 'U' ||c == 'V' ||
                    c == 'W' ||c == 'X' ||c == 'Y' ||c == 'Z' ||c =='Ñ'){
                isConsonant = true;
            }
        }

        return isConsonant;
    }
}
