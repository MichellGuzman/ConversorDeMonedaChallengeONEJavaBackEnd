package com.alura.conversorDeMoneda.archivosDeTexto;

import java.io.File;
import java.io.IOException;

public class AbrirBlocNotas {

    String os = System.getProperty("os.name").toLowerCase();


     // Cambia esto por la ruta de tu archivo

    public AbrirBlocNotas(String nombreArchivo){
        System.out.println(os);
        String rutaArchivo = "src/ArchivosDeTexto/" + nombreArchivo;
        // Crear un objeto File
        File archivo = new File(rutaArchivo);

        // Abrir el archivo con el Bloc de Notas
        if (archivo.exists()) {
            try {
                abrirArchivo(archivo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    private static void abrirArchivo(File archivo) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();

        ProcessBuilder processBuilder;

        if (os.contains("win")) {
            // Windows
            processBuilder = new ProcessBuilder("notepad.exe", archivo.getAbsolutePath());
        } else if (os.contains("mac")) {
            // macOS
            processBuilder = new ProcessBuilder("open", archivo.getAbsolutePath());
        } else if (os.contains("nix") || os.contains("nux")) {
            // Linux (distribuciones que usan "open" o "xdg-open")
            processBuilder = new ProcessBuilder("xdg-open", archivo.getAbsolutePath());
        } else {
            throw new UnsupportedOperationException("Sistema operativo no soportado: " + os);
        }

        processBuilder.start();
    }
}
