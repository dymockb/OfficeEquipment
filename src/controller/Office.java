package controller;

import java.util.ArrayList;

import model.Command;
import util.OfficeMachine;
import model.Printer;

//import model.Player;
//import model.Room;
import util.Parser;
import util.MachineCodes;

/**
 *  
 *  This main class creates and initialises all the others: it creates 
 *  the office, creates the parser, populates the office with machines
 *  and starts the Office Manager.  
 * 
 *  It also evaluates and executes the commands that the parser returns.
 * 
 * @author Dymock Brett
 * @version 1.0
 */

public class Office 
{
    private Parser parser;
    private MachineCodes machineCodes;
    private ArrayList<OfficeMachine> machineInventory;
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
        machineCodes = new MachineCodes();
        machineInventory = new ArrayList<OfficeMachine>();
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

    //private void startOfficeManager(){
    //    System.out.println("office manager started");
    //}

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
            String[] mCodes = machineCodes.getMachineCodes();
            OfficeMachine newMachine;
            for (String m : mCodes){
                if (command.getSecondWord().equals(m)){
                    newMachine = createMachine(m);
                    machineInventory.add(newMachine);
                    System.out.println("A " + newMachine.getType() + " has been installed in the office.");
                    printInventory();
                }
            }
        }
        else if (commandWord.equals("status")) {
        	System.out.println("The office currently has " + machineInventory.size() + " machine(s) installed.");
        }

        return closeOffice;
    }

    private OfficeMachine createMachine(String machineCode){
        if(machineCode.equals("PRT")){
            Printer p = new Printer();
            return p;
        } else {
            return null; 
        }
        
    }

    private void printInventory(){
        System.out.print("Current inventory: ");
        for(OfficeMachine om : machineInventory){
            System.out.print(om.getType());
        }
        System.out.println("");
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("The office is open for business, but it needs some machines to do some work.");
        System.out.println("A few types of machine are available:");
        System.out.println("To add one, type add MACHINE-TYPE. Eg:"); 
        System.out.println("add PRT");
        System.out.println();
        System.out.println("The machine types are:");
        System.out.println("   " + machineCodes.printMachineCodes());
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
