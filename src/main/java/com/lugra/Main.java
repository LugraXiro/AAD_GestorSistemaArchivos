package com.lugra;

import java.util.Scanner;

public class Main {

    static Scanner teclado;

    public static void main(String[] args) {
        
        teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        GestorFicheros gestorF = new GestorFicheros("C:\\Users\\Luis\\Clase\\Repositorios\\AAD_GestorSistemaArchivos\\src\\main\\java\\com\\lugra\\dir_playground");

        do {
           opcion=com.lugra.Menu.pintarMenu();
           switch (opcion) {
    case 1 -> { System.out.println("\tElegiste opción 1");
        System.out.println("\tListando archivos y carpetas...");

        gestorF.listarArchivosYCarpetas();
    }
    case 2 -> { System.out.println("\tElegiste opción 2");
        System.out.println("\tVer los permisos del fichero...");
    }
    case 3 -> { System.out.println("\tElegiste opción 3");
        System.out.println("\tLeer el fichero...");
    }
    case 4 -> { System.out.println("\tElegiste opción 4");
        System.out.println("\tEscribir en el fichero...");
    }
    case 5 -> { System.out.println("\tElegiste opción 5");
        System.out.println("\tCrear un fichero...");
    }
    case 6 -> { System.out.println("\tElegiste opción 6");
        System.out.println("\tBorrar un fichero...");
    }
    case 7 -> { System.out.println("\tElegiste opción 7");
        System.out.println("\tCrear un directorio...");
    }
    case 8 -> { System.out.println("\tElegiste opción 8");
        System.out.println("\tBorrar un directorio...");
    }
    case 9 -> { System.out.println("\tElegiste opción 9");
        System.out.println("\tMostrar la ruta absoluta de un fichero...");
    }
    case 0 -> { System.out.println("\tElegiste opción 0");
        salir = true;
        System.out.println("\tSaliendo del programa...");
    }
    default -> System.out.println("Opción incorrecta");
}
        } while (!salir);
    }  // fin main  
}