package cli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import cli.commands.Command;
import cli.commands.Echo;
import cli.commands.Exit;
import cli.commands.Help;
import cli.commands.List;
import cli.commands.Manual;

/**
 * Class that models the behavior of a command line interface.
 * 
 * @author Jesús Israel Gutiérrez Elizalde.
 * @version 1.1.1
 */
public class Cli {

    private HashMap<String, Command> commands;
    private boolean exit;
    private boolean running;
    private Scanner scanner;
    private boolean scannerClosed;
    private String name;
    private boolean colors;

    /**
     * Constructor without parameters of a cli.
     * 
     * @param name   -- String that will be the name displayed in the command
     *               prompt.
     * @param colors -- Boolean to determine if the cli will have colors.
     *               The colors are for the command prompt and some messages for the
     *               user.
     * @throws IllegalArgumentException if the specified string is null.
     */
    public Cli(String name, boolean colors) {
        if (name == null)
            throw new IllegalArgumentException("null argument at constructor.");
        this.commands = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.name = name;
        this.colors = colors;
        addCommand(new Exit(this));
        addCommand(new Manual(this));
        addCommand(new List(this));
        addCommand(new Help());
        addCommand(new Echo());
    }

    /**
     * Adds a command to the cli; if the name of the specified command in not
     * already in the cli commands.
     * 
     * @param command -- command to be added.
     * @throws IllegalArgumentException if the specified command is null.
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
     * 
     * @throws IllegalStateException if the cli is not running.
     */
    public void exit() {
        if (!this.running)
            throw new IllegalStateException("The cli is not running");
        this.exit = true;
    }

    /**
     * Runs the entire command line interface. This method uses the scanner object
     * of the class and prints in console.
     * 
     * @throws IllegalStateException if the scanner of this cli is already closed.
     */
    public void run() {
        if (this.scannerClosed)
            throw new IllegalStateException("The scanner of this cli is already closed.");
        this.running = true;
        String adviceMsg = "Welcome to the command line interface!!!\n\n";
        adviceMsg += "Need help?, type:\n\n";
        adviceMsg += this.name + "> help\n\n";
        adviceMsg += "Then press ENTER.";
        String noCmd = (this.colors) ? "\033[31mcommand not found\033[0m: " : "command not found: ";
        String prompt = (this.colors) ? "\n\033[32m" + this.name + "\033[0m> " : "\n" + this.name + "> ";
        adviceMsg = (this.colors) ? "\n\033[33m" + adviceMsg + "\033[0m" : "\n" + adviceMsg;
        String byeMsg = (this.colors) ? "\n\033[33mGoodbye :)\033[0m\n" : "\nGoodbye :)\n";
        System.out.println(adviceMsg);
        while (!this.exit) {
            System.out.print(prompt);
            LinkedList<String> commandAndOptions = splitString(scanner.nextLine());
            String nameOfTheCmd = "";
            if (!commandAndOptions.isEmpty())
                nameOfTheCmd = commandAndOptions.getFirst();
            try {
                if (!runCommand(commandAndOptions))
                    System.out.println(noCmd + nameOfTheCmd);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println(byeMsg);
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
     * @return boolean -- true if the command exists and it was executed.
     * @throws IllegalArgumentException if the specified list is null.
     */
    public boolean runCommand(LinkedList<String> commandAndOptions) {
        if (commandAndOptions == null)
            throw new IllegalArgumentException("null argument at runCommand().");
        if (commandAndOptions.isEmpty())
            return true;
        String commandName = commandAndOptions.removeFirst();
        Command commandToRun = this.commands.get(commandName);
        if (commandToRun == null)
            return false;
        commandToRun.run(commandAndOptions);
        return true;
    }

    /**
     * Splits the string by spaces and each element in the splitted string is added
     * to a list, the returns that list.
     * 
     * @param string -- string to be splitted.
     * @return LinkedList<String> -- list with the splitted elements.
     * @throws IllegalArgumentException if the specified string is null.
     */
    private LinkedList<String> splitString(String string) {
        if (string == null)
            throw new IllegalArgumentException("null argument at splitString().");
        string = string.strip();
        LinkedList<String> splittedString = new LinkedList<>();
        if (string.isEmpty())
            return splittedString;
        String[] splittedBySpaces = string.split(" ");
        for (String stringInArray : splittedBySpaces)
            if (!stringInArray.equals(" ") && !stringInArray.equals(""))
                splittedString.addLast(stringInArray);
        return splittedString;
    }

    /**
     * Method to get the scanner of the cli.
     * 
     * @return Scanner -- the scanner that this cli is using.
     */
    public Scanner getScanner() {
        return this.scanner;
    }
}