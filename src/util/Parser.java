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
    private CommandWords inventoryCommands;
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        //commands = new CommandWords();
        inventoryCommands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
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
        if(inventoryCommands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }

    /**
     * @return The next command from the user.
     
    public Command getCommand() 
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
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }
    */    
    
    /**
     * Returns a printable String of valid command words as determined
     * by the CommandWords class
     * @return String of valid command words
     */
    public String getPrintableCommandWords() {
    	return inventoryCommands.getPrintableCommandWords();
    }
}
