package controller;

import model.Command;
//import model.Player;
//import model.Room;
import util.Parser;

/**
 *  
 *  This main class creates and initialises all the others: it creates 
 *  the office, creates the parser, populates the office with machines
 *  and starts the Office Manager.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author Dymock Brett
 * @version 1.0
 */

public class Office 
{
    private Parser parser;
    //private Room startingPlace;
    //private Player player;
        
    /**
     * The main method: this is what happens first when the program is run.
     * It creates an Office object, then - with user prompts - adds machines to the Office and
     * optionally runs the office manager.
     */
    public static void main(String[] args) {
    	Office office = new Office();
    	office.openForBusiness();
    }
        
    /**
     * Create the game and initialise its internal map.
     */
    public Office() 
    {
        parser = new Parser();
    }

    /**
     * Add machines to the office
     */
    private void openForBusiness()
    {
        printWelcome();
        boolean closed = false;
        while (!closed) {
            Command command = parser.getInventoryCommand();
            closed = processCommand(command);
        }
        System.out.println("The office is now closed.");
    }

    private void startOfficeManager(){
        System.out.println("office manager started");
    }

    /**
     * Print out the opening message.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to your new office.");
        System.out.println("Let's add some machines to help get the work done.");
        System.out.println("Choose a machine: PRT or CPY");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, or if the Player 
     * 				dies, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean closeOffice = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            System.out.println("Please type a two-word command.");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("quit")) {
            closeOffice = quit(command);
        }
        else if (commandWord.equals("add")) {
            System.out.println(command.getSecondWord());
        	System.out.println("add machine method needed");
        }

        return closeOffice;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university - as long as you are healthy.");
        System.out.println("Your health goes down by 2 when you move to a new location, "); 
        System.out.println("but it can also be affected by the things you eat.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   " + parser.getPrintableCommandWords());
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
