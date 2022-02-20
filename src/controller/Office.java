package controller;

import model.Command;
import model.Player;
import model.Room;
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
    private Room startingPlace;
    private Player player;
        
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
    }



    /**
     *  Main play routine.  Loops until end of play (Player quits or dies).
     */
    public void play() 
    {            
    	player = new Player(startingPlace);
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Your final score was "+player.getScore());
        System.out.println("Thank you for playing.  Good bye.");
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
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            System.out.println("Please type a two-word command.");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("eat")) {
        	System.out.println(player.eat());
        }
        else if (commandWord.equals("get")) {
        	player.getItem(command);
            //getItem(command);
        }
        else if (commandWord.equals("inventory")) {
        	player.printInventory();
        }

        if(!player.isAlive()) {
        	System.out.println("You have died");
        	// set the wantToQuit flag to force the game to end
        	wantToQuit = true;
        }

        return wantToQuit;
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
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentLocation().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            player.setCurrentLocation(nextRoom);
            player.incrementScore();
            player.updateHealth(-2);
            System.out.println("You are " + player);
            System.out.println();
        }
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
