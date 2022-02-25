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

public class LeadingZeros
{

    /**
     * Constructor - initialise the command words.
     */
    public LeadingZeros(){

    }

    /**
     */
    public static String convertInteger(int num){
        if(num > 99){
            return "" + num;
        } else {
            if(num < 10){
                return "00" + num;
            } else {
                return "0" + num;
            }
        }
    }

    public static int convertString(String num){
        
        return Integer.parseInt(num);

    }
}
