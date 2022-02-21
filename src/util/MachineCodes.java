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
    private static final String[] machineCodes = {
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
        for(int i = 0; i < machineCodes.length; i++) {
            if(machineCodes[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    /**
     * @return an array of all valid machine codes
     */
    public String[] getMachineCodes() {
    	return machineCodes;
    }

    public String printMachineCodes(){
        String output = "";
        for(String code : machineCodes){
            output += code + " ";
        }
        return output;
    }
}
