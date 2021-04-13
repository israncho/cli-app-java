package cli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import cli.commands.Command;
import cli.commands.Exit;
import cli.commands.List;
import cli.commands.Manual;

/**
 * Class that models the behavior of a command line interface.
 * 
 * @author Jesús Israel Gutiérrez Elizalde.
 * @version 1.1.0
 */
public class Cli {

    private HashMap<String, Command> commands;
    private boolean exit;
    private boolean running;
    private Scanner scanner;
    private boolean scannerClosed;

    /**
     * Constructor without parameters of a cli.
     */
    public Cli() {
        this.commands = new HashMap<>();
        this.scanner = new Scanner(System.in);
        addCommand(new Exit(this));
        addCommand(new Manual(this));
        addCommand(new List(this));
    }

    /**
     * Adds a command to the cli; if the name of the specified command in not
     * already in the cli commands.
     * 
     * @param command -- command to be added.
     */
    public void addCommand(Command command) {
        if (command == null)
            throw new IllegalArgumentException("Null argument at addCommand().");
        if (!this.commands.containsKey(command.name()))
            this.commands.put(command.name(), command);
    }

    /**
     * Closes the scanner of this cli, so after using this command it will not be
     * possible to use the {@link #run()} method.
     */
    public void closeScanner() {
        this.scannerClosed = true;
        this.scanner.close();
    }

    /**
     * Exits the cli only if it is running.
     */
    public void exit() {
        if (this.running)
            this.exit = true;
        else
            throw new IllegalStateException("The cli is not running");
    }

    /**
     * Runs the entire command line interface. This method uses the scanner object
     * of the class and prints in console.
     */
    public void run() {
        if (this.scannerClosed)
            throw new IllegalStateException("The scanner of this cli is already closed.");
        this.running = true;
        System.out.println("\n\033[33mWelcome to the command line interface!!!\033[0m");
        while (!this.exit) {
            System.out.print("\n\033[32mmain\033[0m > ");
            LinkedList<String> commandAndOptions = splitString(scanner.nextLine());
            String nameOfTheCmd = "";
            if (!commandAndOptions.isEmpty())
                nameOfTheCmd = commandAndOptions.getFirst();
            if (!runCommand(commandAndOptions))
                System.out.println("\033[31mcommand not found\033[0m: " + nameOfTheCmd);
        }
        System.out.println("\n\033[33mGoodbye :)\033[0m\n");
        this.exit = false;
        this.running = false;
    }

    /**
     * Returns a copy of the commands in the cli. The commands are mapped with their
     * name, so use their name as key.
     * 
     * @return HashMap<String, Command> -- Copy of the command in the cli.
     */
    public HashMap<String, Command> getCommands() {
        HashMap<String, Command> copy = new HashMap<>();
        for (Command command : this.commands.values())
            copy.put(command.name(), command);
        return copy;
    }

    /**
     * Try to run the command in the specified list. Returns true if the command
     * exists and it was executed.
     * 
     * @param commandAndOptions
     * @return
     */
    public boolean runCommand(LinkedList<String> commandAndOptions) {
        if (commandAndOptions.isEmpty())
            return true;
        String commandName = commandAndOptions.removeFirst();
        Command commandToRun = this.commands.get(commandName);
        if (commandToRun != null) {
            commandToRun.run(commandAndOptions);
            return true;
        } else
            return false;
    }

    /**
     * Splits the string by spaces and each element in the splitted string is added
     * to a list, the returns that list.
     * 
     * @param string -- string to be splitted.
     * @return LinkedList<String> -- list with the splitted elements.
     */
    private LinkedList<String> splitString(String string) {
        string = string.strip();
        LinkedList<String> splittedString = new LinkedList<>();
        if (string.isEmpty())
            return splittedString;
        String[] splittedBySpaces = string.split(" ");
        for (String stringInArray : splittedBySpaces)
            splittedString.addLast(stringInArray);
        return splittedString;
    }
}