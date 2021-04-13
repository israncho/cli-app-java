package cli.commands;

import java.util.LinkedList;

import cli.Cli;

/**
 * Class for the list command in the cli.
 * 
 * @author Jesús Israel Gutiérrez Elizalde
 * @version 1.0
 */
public class List implements Command {

    private Cli cli;

    /**
     * Constructs a list command for the specified cli.
     * 
     * @param cli -- cli that is going to use this new exit command.
     */
    public List(Cli cli) {
        this.cli = cli;
    }

    @Override
    public void run(LinkedList<String> options) {
        int count = 1;
        System.out.println("\n\033[33mAvailable commands:\033[0m");
        for (String string : this.listNames())
            System.out.println("\033[35m" + (count++) + "-" + "\033[0m " + string);
    }

    /**
     * Returns the names of all the available commands in the cli that uses this
     * list command.
     * 
     * @return LinkedList<String> -- names of the available commands.
     */
    public LinkedList<String> listNames() {
        LinkedList<String> listNames = new LinkedList<>();
        for (Command command : this.cli.getCommands().values())
            listNames.addLast(command.name());
        return listNames;
    }

    @Override
    public String name() {
        return "list";
    }

    @Override
    public String manual() {
        String message = "\n";
        message += "\033[35mlist\033[0m\n";
        message += "\033[36mNAME\033[0m\n";
        message += "\tlist - lists all the available command for the cli.\n";
        message += "\033[36mDESCRIPTION\033[0m\n";
        message += "\tUseful command to know all the functionalities of the cli.";
        message += this.optionsAndUsage();
        return message;
    }

    @Override
    public String optionsAndUsage() {
        String message = "\n\n";
        message += "\033[36mUsage:\033[0m list [options]\n\n";
        message += "\033[36mOptions:\033[0m\n";
        message += "\tThis command has no options.\n";
        return message;
    }
}