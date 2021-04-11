package cli.commands;

/**
 * Interface that models the behavior of the commands of a command line
 * interface.
 * 
 * @author Jesus Israel Gutierrez Elizalde.
 * @version 1.0
 */
public interface Command {

    /**
     * Performs the action of the command.
     * 
     * @param parameters -- Parameters of the command.
     */
    public void action(String[] parameters);

    /**
     * Returns the name of the command. Interface that models the behavior of the
     * commands of a command line interface.
     * 
     * @return String -- Name of the command.
     */
    public String name();

    /**
     * Returns the manual of the command; description of how to use the command.
     * 
     * @return String -- The manual of the command.
     */
    public String manual();
}
