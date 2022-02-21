package util;

/*  
 * 
 * This class holds an enumeration of all machine types available for use
 * in the office.
 * It is used to recognise these machine types as they are typed in.
 *
 * @author  Dymock Brett
 * @version v1.0
 */

public class MachineCodes
{
    // a constant array that holds all valid machines
    private static final String[] validMachineCodes = {
        "PRT","CPY" 
    };

    /**
     * Constructor - initialise the command words.
     */
    public MachineCodes()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid machine code. 
     * @return true if a given string is a valid machine code,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validMachineCodes.length; i++) {
            if(validMachineCodes[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    /**
     * Returns a printable String of all valid command words
     * @return String of command words
     */
    public String getValidMachines() {
    	String printableWords = "";
    	for(String word : validMachineCodes) {
    		printableWords += word + " ";
    	}
    	return printableWords;
    }
}
