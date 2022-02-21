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

    protected String machineCode;
    protected String machineType;
    protected int machineNumber;

    public OfficeMachine(){

    }

    public String getCode(){
        return machineCode;
    }

    public String getType(){
        return machineType;
    }

    public int getNumber(){
        return machineNumber;
    }

    public abstract void processJob();
    
    public String toString() {
        return "desc of office machine";
    }

}
