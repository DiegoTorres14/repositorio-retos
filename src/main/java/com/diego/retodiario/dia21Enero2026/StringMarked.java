package com.diego.retodiario.dia21Enero2026;

public class StringMarked {
    /*
     * Reto día -- 21/Enero/2026
     * Se recibe una cadena de marcado que puede contener parte de código en su interior.
     * El código se ve porque va entrecomillado con comillas simples --> 'ejemplo'.
     * */

    public static void main(String[] args) {
        try{
            if (args.length != 1)
                throw new Exception("Los argumentos de llamada del programa deben ser 1.");
            System.out.println("Mensaje inicial: " + args[0]);
            System.out.println("Mensaje convertido: " + parseInlineCode(args[0]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String parseInlineCode(String markdown){
        boolean esPrimeraComilla = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < markdown.length(); i++){
            if (markdown.toCharArray()[i] == '\''){
                if (esPrimeraComilla){
                    sb.append("<code>");
                    esPrimeraComilla = false;
                } else {
                    sb.append("</code>");
                    esPrimeraComilla = true;
                }
            } else {
                sb.append(markdown.toCharArray()[i]);
            }
        }

        return sb.toString();
    }
}
