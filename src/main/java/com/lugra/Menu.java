package com.lugra;

import java.util.Scanner;

public class Menu {
    
    static Scanner teclado = new Scanner (System.in);
    
      
    
   public static int pintarMenu (){
        System.out.println("\n\n\n");
        System.out.println("=== GESTOR DE SISTEMA DE ARCHIVOS ===");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Listar los archivos y carpetas");
        System.out.println("2. Ver los permisos del fichero");
        System.out.println("3. Leer el fichero");
        System.out.println("4. Escribir en el fichero");
        System.out.println("5. Crear un fichero");
        System.out.println("6. Borrar un fichero");
        System.out.println("7. Crear un directorio");
        System.out.println("8. Borrar un directorio");
        System.out.println("9. Mostrar la ruta absoluta de un fichero");
        System.out.println("0. Salir del programa");
        System.out.print("Opción: ");  
      try {                  //si introduce un valor no entero haría return 999
        return Integer.parseInt (teclado.nextLine());
      } catch (Exception e ) {return 999;}
   }

    
}
