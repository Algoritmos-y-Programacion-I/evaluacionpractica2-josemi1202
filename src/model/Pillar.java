package model;

/**
 * Class representing a strategic Pillar.
 * Each pillar contains an array of projects related to sustainability.
 */
public class Pillar {

    private String name;
    private Project[] projects;
    private int projectCount;

    /**
     * Constructor of the Pillar class.
     * 
     * @param name The name of the pillar.
     */
    public Pillar(String name) {
        this.name = name;
        projects = new Project[50]; // Maximum of 50 projects allowed per pillar.
        projectCount = 0;
    }

    /**
     * Registers a new project in the pillar.
     * 
     * @param newProject The project to be added.
     * @return boolean True if the project was successfully added, false otherwise.
     */
    public boolean registerProject(Project newProject) {
        if (projectCount >= 50) {
            return false; // No more projects can be added if the array is full.
        }
        projects[projectCount] = newProject;
        projectCount++;
        return true;
    }

    /**
     * Checks if a project with the given ID already exists in the pillar.
     * 
     * @param id The project ID to check for.
     * @return boolean True if a project with the same ID is already registered, false otherwise.
     */
    public boolean isProjectIdTaken(String id) {
        for (int i = 0; i < projectCount; i++) {
            if (projects[i].getId().equals(id)) {
                return true; // Found a project with the same ID.
            }
        }
        return false; // No project with the same ID was found.
    }

    /**
     * Retrieves the list of projects in the pillar as a formatted string.
     * 
     * @return String A formatted string listing all projects in the pillar. 
     * If no projects exist, returns a message indicating the pillar is empty.
     */
    public String getProjectList() {
        if (projectCount == 0) {
            return "No hay proyectos registrados en este pilar."; // No projects in the pillar.
        }

        StringBuilder list = new StringBuilder();
        for (int i = 0; i < projectCount; i++) {
            Project project = projects[i];
            list.append((i + 1) + ". ID: " + project.getId() + ", Nombre: " + project.getName() + 
                        " (Status: " + (project.isActive() ? "Activo" : "Inactivo") + ")\n");
        }
        return list.toString();
    }
}
