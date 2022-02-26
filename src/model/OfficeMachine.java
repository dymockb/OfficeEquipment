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
        job = null;
    }

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

    public String getMachineString(){
        return machineType + LeadingZeros.convertInteger(machineCode);
    }

    public Job getJob(){
        return job;
    }

    protected boolean isOnline(){
        return online;
    }

    protected boolean acceptJob(Job nextJob){

        if(job == null && online == true && error == false && nextJob.getJobType().equals(machineType)){
            System.out.println("job accepted, job string is: " + nextJob.getJobString());
            System.out.println("machine accepting: " + getMachineString());

            setJob(nextJob);

            return true;
        } else {
            System.out.println("job not accepted.");
            System.out.println(job == null);
            System.out.println(online == true);
            System.out.println(error == false);
            return false;
        }  
    }

    protected void reset(){
        error = false;
    }

    protected abstract void setJob(Job job);

    protected abstract void processJob();

    public String toString() {
        return "desc of office machine";
    }

}
