package com.alura.conversorDeMoneda.principal;

import com.alura.conversorDeMoneda.archivosDeTexto.AbrirBlocNotas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    public void menuPrincipal(){
        boolean enFuncionamiento = true;
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String nombreArchivo = "";

        System.out.println("BIENBENIDO AL CONVERSOR DE MONEDA");

        while (enFuncionamiento == true){

            System.out.println("Menu principal");
            System.out.println("1) Convertir monedas");
            System.out.println("2) Ver Monedas Apoyadas");
            System.out.println("3) salir");
            System.out.println("***********************");
            System.out.print("¿QUE DESEA HACER?: ");

            try {

                opcion = scanner.nextInt();

                switch (opcion){
                    case 1:
                        ConvercionMonedas convercion = new ConvercionMonedas();
                        convercion.convercionMonedas();
                        break;
                    case 2:
                        System.out.println("Se abrirá el archivo");
                        nombreArchivo = "MonedasApoyadas.txt";
                        AbrirBlocNotas abrirBlocNotas = new AbrirBlocNotas(nombreArchivo);
                        break;
                    case 3:
                        enFuncionamiento = false;
                        System.out.println("Gracias por usar el sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
            }
        }

        scanner.close();

    }
}
