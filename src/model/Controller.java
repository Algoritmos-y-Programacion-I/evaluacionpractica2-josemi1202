package model;

/**
 * Controller class to manage the pillars and their associated projects.
 */
public class Controller {

    private Pillar[] pillars;

    /**
     * Constructor of the Controller class.
     * Initializes the four strategic pillars: Biodiversidad, Agua, Gestión de residuos, and Energia.
     */
    public Controller() {
        pillars = new Pillar[4];
        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Gestión de residuos");
        pillars[3] = new Pillar("Energia");
    }

    /**
     * Registers a project in the specified pillar.
     * 
     * @param pillarType The index of the pillar where the project will be registered (0-3).
     * @param id The unique identifier for the project.
     * @param name The name of the project.
     * @param description A description of the project.
     * @param status The current status of the project (true for active, false for inactive).
     * @return boolean True if the project was successfully registered, false otherwise.
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, boolean status) {
        if (pillarType < 0 || pillarType >= pillars.length) {
            return false; // Validates that the pillar index is within range.
        }

        // Check if a project with the same ID already exists in the pillar
        if (pillars[pillarType].isProjectIdTaken(id)) {
            System.out.println("Error: Ya existe un proyecto con este ID en el pilar seleccionado.");
            return false;
        }

        Project newProject = new Project(id, name, description, status);
        return pillars[pillarType].registerProject(newProject);
    }

    /**
     * Retrieves the list of projects in a specific pillar.
     * 
     * @param pillarType The index of the pillar to retrieve projects from (0-3).
     * @return String A formatted string containing the list of projects in the selected pillar.
     */
    public String queryProjectsByPillar(int pillarType) {
        if (pillarType < 0 || pillarType >= pillars.length) {
            return "¡Pilar Invalido!"; // Validates the selected pillar exists.
        }

        return pillars[pillarType].getProjectList();
    }
}
