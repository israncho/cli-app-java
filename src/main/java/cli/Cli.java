package cli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import cli.commands.Command;
import cli.commands.Exit;

/**
 * Class that models the behavior of a command line interface.
 * 
 * @author Jesus Israel Gutierrez Elizalde.
 * @version 1.0
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
        System.out.println("\033[33mWelcome to the command line interface!!!\033[0m");
        Scanner scanner = new Scanner(System.in);
        while (!this.exit) {
            System.out.print("\033[32mMain\033[0m > ");
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
        scanner.close();
        this.exit = false;
        this.running = false;
    }

    /**
     * Returns the names of all the commands in the cli.
     * 
     * @return LinkedList<String> -- Names of all commands in the cli.
     */
    public LinkedList<String> getCommandsName() {
        LinkedList<String> copyOfCommands = new LinkedList<>();
        for (String command : this.commands.keySet())
            copyOfCommands.addLast(command);
        return copyOfCommands;
    }
}