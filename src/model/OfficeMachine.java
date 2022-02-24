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

    protected String machineCode;
    protected String machineDesc;
    protected int machineNumber;
    protected boolean online;
    protected boolean error;
    protected Job job;

    public OfficeMachine(){
        online = true;
        error = false;
        job = null;
    }

    protected String getCode(){
        return machineCode;
    }

    public String getDesc(){
        return machineDesc;
    }

    protected int getNumber(){
        return machineNumber;
    }

    protected boolean isOnline(){
        return online;
    }

    protected boolean acceptJob(Job job){
        //System.out.println(this.job==null);
        //System.out.println(online==true);
        //System.out.println(error==false);
        //System.out.println(job.getCode().equals(machineCode));
        if(this.job == null && online == true && error == false && job.getJobType().equals(machineCode)){
            return true;
        } else {
            return false;
        }  
    }

    protected void reset(){
        error = false;
    }

    protected abstract void processJob(Job job);

    public String toString() {
        return "desc of office machine";
    }

}
