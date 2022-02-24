package util;
import model.Command;
import java.util.Scanner;

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
    private MachineCodes machineCodes;
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        //commands = new CommandWords();
        commandWords = new CommandWords();
        machineCodes = new MachineCodes();
        reader = new Scanner(System.in);
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

    public boolean checkManagerCommand(String aString, String[] managerCommands)
    {
        for(int i = 0; i < managerCommands.length; i++) {
            if(managerCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    public String getJobOwner() 
    {
        String inputLine;   // will hold the full input line
        System.out.println("Who is the owner of the job? (Type name)");
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        return inputLine;
    }

    public String getJobDescription() 
    {
        String inputLine;   // will hold the full input line
        System.out.println("Please enter a job description");
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        return inputLine;
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
