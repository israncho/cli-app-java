package cli.commands;

import java.util.LinkedList;

/**
 * Class for the help command in the cli.
 * 
 * @author Jesús Israel Gutiérrez Elizalde
 * @version 1.0
 */
public class Help implements Command {

    @Override
    public void run(LinkedList<String> options) {
        System.out.println(this.helpMessage());
    }

    @Override
    public String name() {
        return "help";
    }

    public String helpMessage() {
        String message = "\n";
        message += "To see all the available commands run the command \"list\".\n";
        message += "> list\n\n";
        message += "To see what each command does and how to use them, use the\n";
        message += "command \"manual\" followed by the command you want to check.\n";
        message += "> manual [some command]\n";
        message += "Now a real example:\n";
        message += "> manual list\n\n";
        message += "To close this cli run the command \"exit\".\n";
        message += "> exit";
        return message;
    }

    @Override
    public String manual() {
        String message = "\n";
        message += "help\n";
        message += "NAME\n";
        message += "\thelp - shows a useful message to the user who is  \n";
        message += "\t       stuck for the first time using this cli.\n";
        message += "DESCRIPTION\n";
        message += "\tBest first command to run.";
        message += this.optionsAndUsage();
        return message;
    }

    @Override
    public String optionsAndUsage() {
        String message = "\n\n";
        message += "Usage: help [options]\n\n";
        message += "Options:\n";
        message += "\tThis command has no options.\n";
        return message;
    }
}