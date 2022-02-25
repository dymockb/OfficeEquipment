package model;

import util.Parser;
/** 
 * This class holds information about a job that will be assigned to a machine.

 * @author  Dymock Brett
 * @version v1.0
 */

public abstract class Job
{
    protected String description;
    protected String owner;
    protected String jobType;
    private static Parser parser;

    /**
     */
    public Job()
    {

    }

    public static Job createJob(String jobType){   
        parser = new Parser();
        String ownerInput = parser.getJobOwner();
        String descriptionInput = parser.getJobDescription();
        if(jobType.equals("PRT")){
            return new PrinterJob(jobType, ownerInput, descriptionInput);
        } else {
            return null;
        }

    }


    public String getJobDescription(){
        return description;
    }

    public String getJobOwner(){
        return owner;
    }

    public String getJobType(){
        return jobType;
    }
}

