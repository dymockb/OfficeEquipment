package util;

/*  
 * 
 * This class converts an integer below 100 to a string of three characters,
 * adding leading zeros as necessary - and vice versa (converts a number string
 * to an integer) .
 *
 * @author  Dymock Brett
 * @version v1.0
 */

public class IntegerRequiredError extends Exception
{

    /**
     * Constructor - initialise the command words.
     */
    public IntegerRequiredError(){
        super();
        
    }

    public String toString(){
        return "A number value is required";
    }

    /**
     */

}
