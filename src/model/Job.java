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
    /**
     */
    public Job()
    {

    }

    public static Job createJob(String jobType, Parser parser){   

        int ownerInput = -1;
        boolean gettingOwner = true;
        while(gettingOwner){
            ownerInput = parser.getJobOwner();
            if(ownerInput != -1){
                gettingOwner = false;
            }
        }

        String descriptionInput = parser.getJobDescription();

        System.out.println("job type:" + jobType);

        if (jobType.equals("CPY")){
            return new CopierJob(jobType, ownerInput, descriptionInput, parser);
        } else if (jobType.equals("FPR")){
            return new FoodProcessorJob(jobType, ownerInput, descriptionInput, parser);
        } else {
            return new StandardJob(jobType, ownerInput, descriptionInput);
        }

    }

    public void setJobType(String type){
        jobType = type;
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

    public void setJobOwner(int code){
        owner = code;
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

    public abstract int getNoOfCopies();

    public abstract int getTemperature();
}

