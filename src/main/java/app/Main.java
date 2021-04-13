package app;

import cli.Cli;

/**
 * Main class that runs the program.
 * 
 * @author Jesús Israel Gutiérrez Elizalde.
 */
public class Main {
    public static void main(String[] args) {
        Cli cli = new Cli();
        cli.run();
        cli.closeScanner();
    }
}