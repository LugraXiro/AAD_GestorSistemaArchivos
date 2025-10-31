package com.lugra;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorFicheros {
    private final File carpetaBase;

    public GestorFicheros(String rutaCarpetaBase) {
        this.carpetaBase = new File(rutaCarpetaBase);
    }

    public void listarArchivosYCarpetas() {
        if (!carpetaBase.exists()) {
            System.out.println("La carpeta base no existe");
            return;
        }

        File[] lista = carpetaBase.listFiles();
        if (lista == null || lista.length == 0) {
            System.out.println("No hay archivos ni carpetas en " + carpetaBase.getAbsolutePath());
            return;
        }

        System.out.println("\nContenido de: " + carpetaBase.getName());
        listarRecursivo(carpetaBase, 0);
        

    }

    private void listarRecursivo(File dir, int nivel) {
        File[] elementos = dir.listFiles();
        if (elementos == null) return;

        String sangria = "|___".repeat(nivel); // sangría para mostrar jerarquía

        for (File f : elementos) {
            if (f.isDirectory()) {
                System.out.println(sangria + "[DIR]  " + f.getName());
                listarRecursivo(f, nivel + 1); // llamada recursiva: profundiza un nivel
            } else {
                System.out.println(sangria + "[FILE] " + f.getName());
            }
        }
    }

    public void verPermisos(String nombreFichero) {
        File f = new File(carpetaBase, nombreFichero);

        if (!f.exists()) {
            System.out.println("El fichero o carpeta no existe dentro de " + carpetaBase.getName());
            return;
        }

        System.out.println("\n=== Permisos de " + f.getName() + " ===");
        System.out.println("Tipo -> " + (f.isDirectory() ? "Directorio" : "Archivo"));
        System.out.println("Lectura -> " + (f.canRead() ? "Sí" : "No"));
        System.out.println("Escritura -> " + (f.canWrite() ? "Sí" : "No"));
        System.out.println("Ejecución: -> " + (f.canExecute() ? "Sí" : "No"));
    }

    public void leerFichero(String nombreFichero) {
        try (FileReader fr = new FileReader(nombreFichero)){
            // try-with-resources -> forma moderna de cerrar el fichero automat. al terminar
            int c; // guardamos cada carácter como entero entre 0 y 65535
            while((c = fr.read()) != -1) { // -1 indica fin archivo
                System.out.print((char) c);
                // "(char) c" -> convierte el entero "c" en un carácter legible
            }
        }catch (IOException e){
            System.out.println("Error al leer el fichero: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }   
    }

    public void escribirFichero(String nombreFichero, String contenidoAgregado) {
        try (FileWriter fw = new FileWriter(nombreFichero, true)) {
            // true -> modo "append" (añadir al final del fichero)
            fw.write(contenidoAgregado + "\n");
            fw.flush(); // asegura que todo se escribe en el fichero
            System.out.println("Escritura completada en " + nombreFichero);
        } catch (Exception e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
    }
}