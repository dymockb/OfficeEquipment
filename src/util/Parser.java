package util;

import java.io.File;
import model.Command;
import java.util.Scanner;

import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileNotFoundException;

/**
 * This class is part of the "OfficeEquipment" application. 
 * 
 * This parser reads user input and returns the command
 * as an object of class Command.
 *
 * The parser has two sets of known command words - one for managing the inventory of
 * office machines, and another for managing instructions given to individual machines. 
 * It checks user input against the known commands, and if the input is not one of the 
 * known commands, it returns a command object that is marked as an unknown command.
 * 
 * @author  Dymock Brett
 * @version 1.0
 */
public class Parser 
{
    //private CommandWords commands;  // holds all valid command words
    private CommandWords commandWords;
    private MachineTypes machineCodes;
    private Scanner reader;         // source of command input
    private boolean testingOn;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commandWords = new CommandWords();
        machineCodes = new MachineTypes();
        reader = new Scanner(System.in);
        testingOn = false;
    }

    /** */
    public Parser(String testFile) throws FileNotFoundException
    {
        commandWords = new CommandWords();
        machineCodes = new MachineTypes();
        File file= new File(testFile);
        reader = new Scanner(file);
        testingOn = true;
    }


    /**
     * @return The next Job command from the user when setting up the office.
     */
    public Command getInventoryCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();
        printInput(inputLine);

        // Find up to two words on the line.
        try (Scanner tokenizer = new Scanner(inputLine)){
        
            if(tokenizer.hasNext()) {
                word1 = tokenizer.next();      // get first word
                if(tokenizer.hasNext()) {
                    word2 = tokenizer.next();      // get second word
                    // note: we just ignore the rest of the input line.
                }
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(commandWords.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }

    /**
     * @return The next command from the user.
     */
    public Command getManagerCommand(String[] managerCommands) 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();
        printInput(inputLine);

        // Find up to two words on the line.
        try (Scanner tokenizer = new Scanner(inputLine)){
        
            if(tokenizer.hasNext()) {
                word1 = tokenizer.next();      // get first word
                if(tokenizer.hasNext()) {
                    word2 = tokenizer.next();      // get second word
                    // note: we just ignore the rest of the input line.
                }
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(checkManagerCommand(word1, managerCommands)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2); 
        }
    }

    /**
     * @return The next command from the user.
     */
    public Command getJobCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();
        printInput(inputLine);

        // Find up to two words on the line.
        try (Scanner tokenizer = new Scanner(inputLine)){
        
            if(tokenizer.hasNext()) {
                word1 = tokenizer.next();      // get first word
                if(tokenizer.hasNext()) {
                    word2 = tokenizer.next();      // get second word
                    // note: we just ignore the rest of the input line.
                }
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(machineCodes.isValidCode(word1)) {
            return new Command(word1, word2);
        } else if (word1.equals("done")){
            return new Command(word1, word2);
        } else {
            return new Command(null, word2); 
        }
    }

    private void printInput(String input){
        if(testingOn){
            System.out.println(input);
        }
    }

    public boolean checkManagerCommand(String aString, String[] managerCommands)
    {
        for(int i = 0; i < managerCommands.length; i++) {
            if(managerCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    public int getJobOwner () throws NumberFormatException
    {
        String inputLine;   // will hold the full input line
        System.out.println("Who is the owner of the job? (Type an employee number)");
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        printInput(inputLine);

        try {
            return Integer.parseInt(inputLine);
        } catch (NumberFormatException e) {
            System.out.println("An employee number is required.");
            return -1;
        }

    }

    public String getJobDescription() 
    {
        String inputLine;   // will hold the full input line
        System.out.println("Please enter a job description");
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        printInput(inputLine);
        return inputLine;
    }

    public int getCopierInfo(){
        String inputLine;
        System.out.println("Please enter the number of Copies needed.");        
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        printInput(inputLine);
        return Integer.parseInt(inputLine);
    }

    public int setTemperature(){
        String inputLine;
        System.out.println("Please enter the current Temperature:");        
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        printInput(inputLine);
        return Integer.parseInt(inputLine);
    }


    /**
     * Returns a printable String of valid command words as determined
     * by the CommandWords class
     * @return String of valid command words
     */
    public String getPrintableCommandWords() {
    	return commandWords.getPrintableCommandWords();
    }
}
