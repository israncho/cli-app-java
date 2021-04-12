package cli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import cli.commands.Command;
import cli.commands.Exit;
import cli.commands.Manual;

/**
 * Class that models the behavior of a command line interface.
 * 
 * @author Jesús Israel Gutiérrez Elizalde.
 * @version 1.0.1
 */
public class Cli {

    private HashMap<String, Command> commands;
    private boolean exit;
    private boolean running;

    /**
     * Constructor without parameters of a cli.
     */
    public Cli() {
        this.commands = new HashMap<>();
        this.exit = false;
        this.running = false;
        addCommand(new Exit(this));
        addCommand(new Manual(this));
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
     * Exits the cli only if it is running.
     */
    public void exit() {
        if (this.running)
            this.exit = true;
    }

    /**
     * Runs the entire command line interface.
     */
    public void run() {
        this.running = true;
        System.out.println("\n\033[33mWelcome to the command line interface!!!\033[0m\n");
        Scanner scanner = new Scanner(System.in);
        while (!this.exit) {
            System.out.print("\033[32mmain\033[0m > ");
            String userIntput = scanner.nextLine();
            if (userIntput.isBlank())
                continue;
            userIntput = userIntput.strip();
            String[] splitedUserInput = userIntput.split(" ");
            LinkedList<String> cmdAndOptions = new LinkedList<>();
            for (String string : splitedUserInput)
                cmdAndOptions.addLast(string);
            String nameOfTheCmd = cmdAndOptions.removeFirst();
            Command commandToRun = this.commands.get(nameOfTheCmd);
            if (commandToRun != null)
                commandToRun.action(cmdAndOptions);
            else
                System.out.println("\033[31mcommand not found\033[0m: " + nameOfTheCmd);
        }
        System.out.println("\n\033[33mGoodbye :)\033[0m\n");
        scanner.close();
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
}