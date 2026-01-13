package Tareas.Tarea37;

import java.util.Scanner;

public class Tarea37 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        System.out.print("Introduce el texto: ");
        String texto = sc.nextLine().toUpperCase();

        System.out.print("Introduce el desplazamiento: ");
        int desplazamiento = sc.nextInt();

        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            int posicionActual = alfabeto.indexOf(caracter);

            if (posicionActual != -1) {
                int nuevaPosicion = (posicionActual + desplazamiento) % 27;

                if (nuevaPosicion < 0) nuevaPosicion += 27;

                resultado += alfabeto.charAt(nuevaPosicion);
                } else {
                    resultado += caracter;
                }
            }

        System.out.println("Texto cifrado: " + resultado);
        sc.close();
        }
    }