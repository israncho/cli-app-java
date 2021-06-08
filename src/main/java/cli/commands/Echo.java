package cli.commands;

import java.util.LinkedList;

/**
 * Class for the echo command in the cli.
 * 
 * @author Jesús Israel Gutiérrez Elizalde
 * @version 1.0
 */
public class Echo implements Command {

    @Override
    public void run(LinkedList<String> options) {
        if (options.isEmpty())
            return;
        String line = "";
        for (String string : options) {
            line = line.concat(string.concat(" "));
        }
        System.out.println(line);
    }

    @Override
    public String name() {
        return "echo";
    }

    @Override
    public String manual() {
        String message = "\n";
        message += "echo\n";
        message += "NAME\n";
        message += "\techo - Displays on console a line of text.\n";
        message += "DESCRIPTION\n";
        message += "\tDisplays on console the line of text given as argument.";
        message += this.optionsAndUsage();
        return message;
    }

    @Override
    public String optionsAndUsage() {
        String message = "\n\n";
        message += "Usage: echo [options] [string]\n\n";
        message += "Options:\n";
        message += "\tThis command has no options.\n";
        return message;
    }

}