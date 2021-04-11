package cli.commands;

import java.util.LinkedList;

/**
 * Interface that models the behavior of the commands of a command line
 * interface.
 * 
 * @author Jesus Israel Gutierrez Elizalde.
 * @version 1.1
 */
public interface Command {

    /**
     * Performs the action of the command. Some commands have extra usage options.
     * 
     * @param options -- Extra usage options of the command.
     */
    public void action(LinkedList<String> options);

    /**
     * Returns the name of the command. The name of the command is also the id, so
     * two different commands cannot have the same name.
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

    /**
     * Returns the message for wrong options of the command. Must be used when the
     * input for the command is not quite correct.
     * 
     * @return String -- Message for wrong options of the command.
     */
    public String wrongOptions();
}