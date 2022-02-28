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

public abstract class OfficeMachine implements ListenerInterface
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
    protected Listener listener; 
    protected String[] notifications;

    public OfficeMachine(){
        online = false;
        error = false;
        job = null;
        notifications = new String[4];
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

    public Job getJob(){
        return job;
    }

    protected void setJobToNull(){
        job = null;
    }


    public String getMachineString(){
        return machineType + LeadingZeros.convertInteger(machineCode);
    }

    protected boolean getOnlineStatus(){
        return online;
    }

    protected void setOnlineStatus(boolean online){
        
        if(!this.online){
            if(online){
                notifications[2] = "is online. ";
                notifyListener(notifications);
            }
        } else {
            if(!online){
                notifications[2] = "is offline. ";
                notifyListener(notifications);            
            }
        }

        this.online = online;
    
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

    public void setNotifications(){
        notifications[0] = getDesc() + " ";
        notifications[1] = getMachineString() + " ";
        if(!error){
            notifications[3] = "No errors.\n";
        } else {
            notifications[3] = " ** ERROR **.\n";
        }

    }

    public abstract void processJob();

    public String toString() {
        return "desc of office machine";
    }

    public void registerListener(Listener listener){
        this.listener = listener;
    }

    public void notifyListener(String[] notifications){
        listener.receiveNotification(notifications);
    }

}
