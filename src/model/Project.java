package model;

/**
 * Class representing a sustainability project.
 * Each project has a unique ID, name, description, and status.
 */
public class Project {

    private String id;
    private String name;
    private String description;
    private boolean status;

    /**
     * Constructor of the Project class.
     * 
     * @param id The unique identifier for the project.
     * @param name The name of the project.
     * @param description A brief description of the project.
     * @param status The status of the project (true for active, false for inactive).
     */
    public Project(String id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    /**
     * Returns the ID of the project.
     * 
     * @return String The unique identifier of the project.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the project.
     * 
     * @return String The name of the project.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns whether the project is currently active.
     * 
     * @return boolean True if the project is active, false if it is inactive.
     */
    public boolean isActive() {
        return status;
    }
}
