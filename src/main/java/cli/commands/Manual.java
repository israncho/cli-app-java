package cli.commands;

import java.util.HashMap;
import java.util.LinkedList;

import cli.Cli;

/**
 * Class for the manual command in the cli.
 * 
 * @author Jesús Israel Gutiérrez Elizalde
 * @version 1.0
 */
public class Manual implements Command {

    private Cli cli;

    /**
     * Constructs a manual command for the specified cli.
     * 
     * @param cli -- cli that is going to use this new manual command.
     */
    public Manual(Cli cli) {
        this.cli = cli;
    }

    @Override
    public void action(LinkedList<String> options) {
        String nameCommand = null;
        for (String string : options)
            if (!string.substring(0, 1).equals("-")) {
                nameCommand = string;
                options.remove(string);
            }
        HashMap<String, Command> commands = this.cli.getCommands();
        Command commandToUse = commands.get(nameCommand);
        if (commandToUse != null)
            System.out.println(commandToUse.manual());
        else
            System.out.println("\033[31mNo manual for the command\033[0m: " + nameCommand);
    }

    @Override
    public String name() {
        return "manual";
    }

    @Override
    public String manual() {
        String message = "\n";
        message += "\033[35mmanual\033[0m\n";
        message += "\033[36mNAME\033[0m\n";
        message += "\tmanual - shows the manual of the specified command.\n";
        message += "\033[36mDESCRIPTION\033[0m\n";
        message += "\tCommand to get info and know how to use the commands of the system.";
        message += this.optionsAndUsage();
        return message;
    }

    @Override
    public String optionsAndUsage() {
        String message = "\n\n";
        message += "\033[36mUsage:\033[0m manual [options] [arguments]\n\n";
        message += "\033[36mOptions:\033[0m\n";
        message += "\tNo options :(\n";
        return message;
    }
}