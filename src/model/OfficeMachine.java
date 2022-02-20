package model;

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

    private String machineType;
    private int machineNumber;

    public OfficeMachine(String machineType){
        this.machineType = machineType;
        machineNumber = 0;
    }

    public String getMachineType(){
        return machineType;
    }

    public int getMachineNumber(){
        return machineNumber;
    }

    public abstract void processJob();
    
    public String toString() {
        return "desc";
    }

}
