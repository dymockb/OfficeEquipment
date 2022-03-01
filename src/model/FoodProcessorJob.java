package model;

import util.Parser;
/** 
 * This class holds information about a FoodProcessor job.

 * @author  Dymock Brett
 * @version v1.0
 */

public class FoodProcessorJob extends Job
{

    private Parser parser;
    private int temperature;
    /** Constructor for a job
     */
    public FoodProcessorJob(){
        super();
    }

    public FoodProcessorJob(String jobType, int owner, String description, Parser parser)
    {
        super();
        this.parser = parser;
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
        setTemperature();
    }

    // test constructor allowing for temperature to be set as parameter, no parser
    public FoodProcessorJob(String jobType, int owner, String description, int temperature)
    {
        super();
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
        this.temperature = temperature;
    }

    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(){
        temperature = parser.setTemperature(); 
    }

    public int getNoOfCopies(){
        return -1;
    }

}

