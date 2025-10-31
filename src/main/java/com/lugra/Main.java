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
                case 1 -> { System.out.println("\tElegiste opción 1:");
                    System.out.println("\tListando archivos y carpetas...\n");

                    gestorF.listarArchivosYCarpetas();
                }
                case 2 -> { System.out.println("\tElegiste opción 2:");
                    System.out.println("\tVer los permisos del fichero...\n");

                    gestorF.verPermisos(pedirNombre());
                }
                case 3 -> { System.out.println("\tElegiste opción 3:");
                    System.out.println("\tLeer el fichero...\n");

                    gestorF.leerFichero("src\\main\\java\\com\\lugra\\dir_playground\\" + pedirNombre());
                }
                case 4 -> { System.out.println("\tElegiste opción 4:");
                    System.out.println("\tEscribir en el fichero...\n");

                    String contenidoAgregado = "Línea agregada desde el gestor de ficheros.";
                    gestorF.escribirFichero("src\\main\\java\\com\\lugra\\dir_playground\\" + pedirNombre(), contenidoAgregado);
                }
                case 5 -> { System.out.println("\tElegiste opción 5:");
                    System.out.println("\tCrear un fichero...\n");

                    
                }
                case 6 -> { System.out.println("\tElegiste opción 6:");
                    System.out.println("\tBorrar un fichero...\n");
                }
                case 7 -> { System.out.println("\tElegiste opción 7:");
                    System.out.println("\tCrear un directorio...\n");
                }
                case 8 -> { System.out.println("\tElegiste opción 8:");
                    System.out.println("\tBorrar un directorio...\n");
                }
                case 9 -> { System.out.println("\tElegiste opción 9:");
                    System.out.println("\tMostrar la ruta absoluta de un fichero...\n");
                }
                case 0 -> { System.out.println("\tElegiste opción 0:");
                    salir = true;
                    System.out.println("\tSaliendo del programa...\n");
                }
                default -> System.out.println("Opción incorrecta");
}
        } while (!salir);
    }  // fin main  

    static public String pedirNombre() {
        System.out.print("Introduce el nombre: ");
        return teclado.nextLine().trim();
    }
}