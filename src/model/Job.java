package model;

import util.LeadingZeros;
import util.Parser;
/** 
 * This class holds information about a job that will be assigned to a machine.

 * @author  Dymock Brett
 * @version v1.0
 */

public abstract class Job
{
    protected String description;
    protected int owner;
    protected String jobType;
    protected int jobCode;
    private static Parser parser;

    /**
     */
    public Job()
    {

    }

    public static Job createJob(String jobType){   
        parser = new Parser();
        int ownerInput = parser.getJobOwner();
        String descriptionInput = parser.getJobDescription();
        if(!jobType.equals("CPY")){
            return new StandardJob(jobType, ownerInput, descriptionInput);
        } else if (jobType.equals("CPY")){
            System.out.println("owner: " + ownerInput);
            System.out.println("jobType: " + jobType);
            CopierJob newJob = new CopierJob(jobType, ownerInput, descriptionInput);
            return newJob;
        } else {
            System.out.println("no job created.");
            return null;
        }

    }

    public void setJobCode(int code){
        jobCode = code;
    }


    public String getJobDescription(){
        return description;
    }

    public int getJobOwner(){
        return owner;
    }

    public String getJobType(){
        return jobType;
    }

    public int getJobCode(){
        return jobCode;
    }

    public String getJobString(){
        return jobType + LeadingZeros.convertInteger(jobCode);
    }
}

