package cli.commands;

import java.util.LinkedList;

/**
 * Interface that models the behavior of the commands of a command line
 * interface.
 * 
 * @author Jesus Israel Gutierrez Elizalde.
 * @version 1.1.2
 */
public interface Command {

    /**
     * Performs the action of this command. Some commands have extra usage options.
     * 
     * @param options -- Extra usage options of the command.
     */
    public void action(LinkedList<String> options);

    /**
     * Returns the name of this command. The name of the command is also the id, so
     * two different commands cannot have the same name.
     * 
     * @return String -- Name of this command.
     */
    public String name();

    /**
     * Returns the manual of this command; description of how to use the command.
     * 
     * @return String -- The manual of this command.
     */
    public String manual();

    /**
     * Returns the message with the usage and options of this command.
     * 
     * @return String -- Message with the usage and options of this command.
     */
    public String optionsAndUsage();
}