package com.diego.retodiario.dia17Enero2026;

public class KnightMoves {
    public static void main(String[] args) {
        try{
            if (args.length != 1) throw new Exception("Proporciona unicamente el nombre de la casilla a comprobar.");

            // VARIABLES
            String casilla = args[0];
            int [] posicion = {0,0};

            // VALIDACIONES
            // Comprobar que la casilla tenga solamente dos caracteres
            if (casilla.length() != 2) throw new Exception("Formato incorrecto --> A1 - H8");
            casilla = casilla.toUpperCase(); // Para convertir la cadena entera a mayúscula
            char caracter = casilla.toCharArray()[0];
            if (!Character.isLetter(caracter)) throw new Exception("El primer caracter debe ser una letra entre A-H");
            if (caracter != 'A' && caracter != 'B' && caracter != 'C' && caracter != 'D' && caracter != 'E' && caracter != 'F' && caracter != 'G' && caracter != 'H')
                throw new Exception("La letra proporcionada debe estar entre A-H");
            char digito = casilla.toCharArray()[1];
            if (!Character.isDigit(digito)) throw new Exception("El segundo caracter debe ser un número entre 1-8");
            if (digito != '1' && digito != '2' && digito != '3' && digito != '4' && digito != '5' && digito != '6' && digito != '7' && digito != '8')
                throw new Exception("El digito proporcionado debe estar entre 1-8");

            // PROCESAMIENTO
            switch (caracter){
                case 'A':{
                    posicion[0] = 1;
                    break;
                }
                case 'B':{
                    posicion[0] = 2;
                    break;
                }
                case 'C':{
                    posicion[0] = 3;
                    break;
                }
                case 'D':{
                    posicion[0] = 4;
                    break;
                }
                case 'E':{
                    posicion[0] = 5;
                    break;
                }
                case 'F':{
                    posicion[0] = 6;
                    break;
                }
                case 'G':{
                    posicion[0] = 7;
                    break;
                }
                case 'H':{
                    posicion[0] = 8;
                    break;
                }
            }

            posicion[1] = switch (digito){
                case '1' -> 1;
                case '2' -> 2;
                case '3' -> 3;
                case '4' -> 4;
                case '5' -> 5;
                case '6' -> 6;
                case '7' -> 7;
                case '8' -> 8;
                default -> 0;
            };

            // SALIDA
            System.out.println("Para la posición " + casilla + " existen " + knightMoves(posicion) + " movimientos.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static int knightMoves(int[] position) throws Exception {
        int movements = 0;

        // Posicion incorrecta si no cumple con la longitud
        if (position.length != 2) throw new Exception("Posición seleccionada incorrecta");

        // Que no tenga un tamaño más grande del permitido por el tablero
        if (position[0] > 8 || position[1] > 8 || position[0] < 1 || position[1] < 1)
            throw new Exception("Posición seleccionada incorrecta");

        // Comprobar primera altura tablero
        if (position[0] == 1 || position[0] == 8) movements++;
        else movements = movements + 2;

        // Comprobar longitud tablero
        if (position[1] == 1 || position[1] == 8) movements++;
        else movements = movements + 2;

        return movements;
    }
}
