package model;

import util.LeadingZeros;

/*  
 * 
 *
 * @author  Dymock Brett
 * @version v1.0
 */

public class TemperatureException extends Exception
{

    int machineCode;
    int lowerBound;
    int upperBound;
    int actual;
    /**
     * Constructor - 
     */
    public TemperatureException(int machineCode, int lowerBound, int upperBound, int actual){
        super();
        this.machineCode = machineCode;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.actual = actual;
    }

    /**
     */
    public String toString(){
        System.out.println("TemperatureException for machine " + LeadingZeros.convertInteger(machineCode));
        return "Machine temperature out of bounds.  Maximum temperature: " + 
                upperBound + ", minimum temperature: " + lowerBound + ". " +
                "Actual temperature: " + actual;
    }

}
