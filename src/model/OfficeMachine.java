package model;

import util.LeadingZeros;

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
    protected String machineDesc;
    protected int machineCode;
    protected boolean online;
    protected boolean error;
    protected Job job;

    public OfficeMachine(){
        online = true;
        error = false;
    }

    //public static OfficeMachine blankMachine(){
    //    return new BlankMachine();
    //}

    protected String getType(){
        return machineType;
    }

    public String getDesc(){
        return machineDesc;
    }

    public void setCode(int code){
        machineCode = code;
    }

    protected int getCode(){
        return machineCode;
    }

    protected Job getJob(){
        return job;
    }

    protected void setJobToNull(){
        job = null;
    }


    public String getMachineString(){
        return machineType + LeadingZeros.convertInteger(machineCode);
    }

    protected boolean isOnline(){
        return online;
    }

    protected boolean acceptJob(Job job){

        if(this.job == null && online == true && error == false && job.getJobType().equals(machineType)){
            this.job = job;
            return true;
        } else {
            System.out.println("job not accepted");
            return false;
        }  
    }

    protected void reset(){
        error = false;
    }

    protected abstract void processJob();

    public String toString() {
        return "desc of office machine";
    }

}
