package util;

//import java.util.HashMap;

/**
 * Class OfficeMachine - an abstract class describing the general
 * functions of various types of Office Machine.
 *
 * @author  Dymock Brett
 * @version 1.0
 */

public abstract class OfficeMachine 
{
    
    /* 
     * Doc string 
     */

    protected String machineType;
    protected int machineNumber;

    public OfficeMachine(){

    }

    public String getMachineType(){
        return machineType;
    }

    public int getMachineNumber(){
        return machineNumber;
    }

    public abstract void processJob();
    
    public String toString() {
        return "desc of office machine";
    }

}
