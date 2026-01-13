package Tareas.Tarea38;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Scanner;

public class Tarea38 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            // Registro, guardo la contraseña y genero su hash
            System.out.println(" ");
            System.out.println("----- REGISTRO -----");
            System.out.print("Cree una contraseña para su cuenta: ");
            String passwordRegistro = sc.nextLine();

            String hashGuardado = generarHash(passwordRegistro);

            System.out.println("Contraseña procesada y guardada");

            System.out.println("Hash almacenado: " + hashGuardado);

            //Inicio de sesion, se pide otra vez la contraseña, se obtiene el hash y se compara con el otro
            System.out.println(" ");
            System.out.println("----- INICIO DE SESION -----.");
            System.out.print("Introduzca su contraseña: ");
            String passwordLogin = sc.nextLine();

            String hashLogin = generarHash(passwordLogin);

            // compruebo si el hash es el mismo
            if (hashLogin.equals(hashGuardado)) {
                System.out.println("\n ACCESO CONCEDIDO ");
            } else {
                System.out.println("\n ERROR: Credenciales inválidas");
            }

            // manejo errores
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: El algoritmo SHA-256 no está disponible.");
        } finally {
            sc.close();
        }
    }

    //clase para manejar los formatos
    public static String generarHash(String texto) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] resumen = md.digest(texto.getBytes());
        return HexFormat.of().formatHex(resumen);
    }
}