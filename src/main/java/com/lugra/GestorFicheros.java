package com.lugra;

import java.io.File;

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

        System.out.println("\nContenido de: " + carpetaBase.getAbsolutePath());
        for (File f : lista) {
            if (f.isDirectory()) {
                System.out.println("[CARPETA] " + f.getName());
            } else {
                System.out.println("[ARCHIVO] " + f.getName());
            }
        }
    }
}

