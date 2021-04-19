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
     * @throws IllegalArgumentException if the specified cli is null.
     */
    public List(Cli cli) {
        if (cli == null)
            throw new IllegalArgumentException("null argument at list command constructor.");
        this.cli = cli;
    }

    @Override
    public void run(LinkedList<String> options) {
        if (options == null)
            throw new IllegalArgumentException("null argument at List.run()");
        int count = 1;
        System.out.println("Available commands:");
        for (String string : this.listNames())
            System.out.println((count++) + "-" + string);
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
        message += "list\n";
        message += "NAME\n";
        message += "\tlist - lists all the available command for the cli.\n";
        message += "DESCRIPTION\n";
        message += "\tUseful command to know all the functionalities of the cli.";
        message += this.optionsAndUsage();
        return message;
    }

    @Override
    public String optionsAndUsage() {
        String message = "\n\n";
        message += "Usage: list [options]\n\n";
        message += "Options:\n";
        message += "\tThis command has no options.\n";
        return message;
    }
}