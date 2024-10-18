package ui;

import java.util.Scanner;
import model.Controller;

/**
 * Executable class to manage user interactions with the sustainability system.
 */
public class Executable {

    private Controller control;
    private Scanner reader;

    /**
     * Constructor of the Executable class.
     * Initializes the Controller and Scanner for user input.
     */
    public Executable() {
        control = new Controller();
        reader = new Scanner(System.in);
    }

    /**
     * Main method to launch the application.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Displays the main menu to the user, allowing them to register projects or view project lists.
     */
    public void menu() {
        boolean flag = true;

        do {
            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();


            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);
    }

    /**
     * Prompts the user to input information and register a new project in a selected pillar.
     */
    public void registerProject() {
        System.out.println("Seleccione el Pilar para añadir el proyecto:");
        System.out.println("0) Biodiversidad");
        System.out.println("1) Agua");
        System.out.println("2) gestión de residuos");
        System.out.println("3) Energia");
        int pillarType = reader.nextInt();
        reader.nextLine(); // Clears the buffer

        System.out.print("Introduzca el ID del proyecto: ");
        String id = reader.nextLine();

        System.out.print("Introduzca el nombre del proyecto: ");
        String name = reader.nextLine();

        System.out.print("Introduzca la descripcion del proyecto: ");
        String description = reader.nextLine();

          // Asking for the project status (true/false) and validating the input
          Boolean status = null;
          while (status == null) {
              System.out.print("¿El proyecto está activo? (true/false): ");
              String statusInput = reader.nextLine().toLowerCase();
              if (statusInput.equals("true")) {
                  status = true;
              } else if (statusInput.equals("false")) {
                  status = false;
              } else {
                  System.out.println("Opción inválida. Por favor ingrese 'true' o 'false'.");
              }
          }
  
          // Register the project in the selected pillar
          boolean success = control.registerProjectInPillar(pillarType, id, name, description, status);
          if (success) {
              System.out.println("El proyecto ha sido registrado exitosamente.");
          } else {
              System.out.println("No se pudo registrar el proyecto. Verifique que el ID no esté repetido.");
          }
      }
  
    /**
     * Prompts the user to select a pillar and displays the list of projects registered in that pillar.
     */
    public void showProjectsByPillar() {
        System.out.println("Seleccione el Pilar para ver los proyectos:");
        System.out.println("0) Biodiversidad");
        System.out.println("1) Agua");
        System.out.println("2) Gestión de residuos");
        System.out.println("3) Energia");
        int pillarType = reader.nextInt();

        String projects = control.queryProjectsByPillar(pillarType);
        System.out.println("\nproyectos en el pilar seleccionado:\n" + projects);
    }
}