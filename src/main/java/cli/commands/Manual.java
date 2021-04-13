package cli.commands;

import java.util.LinkedList;

import cli.Cli;

/**
 * Class for the manual command in the cli.
 * 
 * @author Jesús Israel Gutiérrez Elizalde
 * @version 1.2
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
    public void run(LinkedList<String> options) {
        System.out.println(optionAndArgs(options));
    }

    /**
     * Returns the content given by running this command depending on the specified
     * options and arguments.
     * 
     * @param optionsAndArgs -- options and arguments for this command.
     * @return String -- message of this command.
     */
    public String optionAndArgs(LinkedList<String> optionsAndArgs) {
        String nameCommand = "";
        boolean correctOption = false;
        boolean withOption = false;
        for (String string : optionsAndArgs) {
            if (!string.substring(0, 1).equals("-")) {
                nameCommand = string;
            } else {
                withOption = true;
                if (string.equals("-u"))
                    correctOption = true;
            }
        }
        if (nameCommand.isEmpty())
            return this.optionsAndUsage();
        Command commandToUse = this.cli.getCommands().get(nameCommand);
        if (commandToUse == null)
            return "\033[31mNo manual for the command\033[0m: " + nameCommand;
        if (withOption)
            if (correctOption)
                return commandToUse.optionsAndUsage();
            else
                return this.optionsAndUsage();
        return commandToUse.manual();
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
        message += "\t-u   just shows the usage and options of the specified command\n";
        return message;
    }
}