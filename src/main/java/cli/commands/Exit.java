package cli.commands;

import java.util.LinkedList;

import cli.Cli;

/**
 * Class for the exit command in the cli.
 * 
 * @author Jesús Israel Gutiérrez Elizalde
 * @version 1.0
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
    public void action(LinkedList<String> options) {
        this.cli.exit();
    }

    @Override
    public String name() {
        return "exit";
    }

    @Override
    public String manual() {
        String message = "\n";
        message += "\033[35mexit\033[0m\n";
        message += "\033[36mNAME\033[0m\n";
        message += "\texit - exits from the command line interface.\n";
        message += "\033[36mDESCRIPTION\033[0m\n";
        message += "\tClassic command to exit from every command line interface.";
        message += this.optionsAndUsage();
        return message;
    }

    @Override
    public String optionsAndUsage() {
        String message = "\n\n";
        message += "\033[36mUsage:\033[0m exit [options]\n\n";
        message += "\033[36mOptions:\033[0m\n";
        message += "\tThis command has no options.\n";
        return message;
    }
}