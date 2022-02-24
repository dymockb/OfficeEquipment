package model;

import util.Parser;
/** 
 * This class holds information about a job that will be assigned to a machine.

 * @author  Dymock Brett
 * @version v1.0
 */

public class Job
{
    private String description;
    private String owner;
    private String jobType;
    private static Parser parser;

    /**
     */
    public Job(String jobType, String owner, String description)
    {
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
    }

    public static Job createJob(String jobType){
        parser = new Parser();
        String ownerInput = parser.getJobOwner();
        String descriptionInput = parser.getJobDescription();
        return new Job(jobType, ownerInput, descriptionInput);
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

