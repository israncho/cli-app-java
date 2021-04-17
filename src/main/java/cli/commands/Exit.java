package cli.commands;

import java.util.LinkedList;

import cli.Cli;

/**
 * Class for the exit command in the cli.
 * 
 * @author Jesús Israel Gutiérrez Elizalde
 * @version 1.1
 */
public class Exit implements Command {

    private Cli cli;

    /**
     * Constructs an exit command for the specified cli.
     * 
     * @param cli -- cli that is going to use this new exit command.
     */
    public Exit(Cli cli) {
        this.cli = cli;
    }

    @Override
    public void run(LinkedList<String> options) {
        this.cli.exit();
    }

    @Override
    public String name() {
        return "exit";
    }

    @Override
    public String manual() {
        String message = "\n";
        message += "exit\n";
        message += "NAME\n";
        message += "\texit - exits from the command line interface.\n";
        message += "DESCRIPTION\n";
        message += "\tClassic command to exit from every command line interface.";
        message += this.optionsAndUsage();
        return message;
    }

    @Override
    public String optionsAndUsage() {
        String message = "\n\n";
        message += "Usage: exit [options]\n\n";
        message += "Options:";
        message += "\tThis command has no options.\n";
        return message;
    }
}