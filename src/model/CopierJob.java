package model;

import util.Parser;
/** 
 * This class holds information about a Copier job.

 * @author  Dymock Brett
 * @version v1.0
 */

public class CopierJob extends Job
{

    private Parser parser;
    private int noOfCopies;
    /** Constructor for a printer job
     */
    public CopierJob(){
        super();
    }

    public CopierJob(String jobType, int owner, String description, Parser parser)
    {
        super();
        this.parser = parser;
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
        setNoOfCopies();
    }

    // test constructor allowing for no of copies to be set as parameter, no parser
    public CopierJob(String jobType, int owner, String description, int noOfCopies)
    {
        super();
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
        this.noOfCopies = noOfCopies;
    }

    public int getNoOfCopies(){
        return noOfCopies;
    }

    public void setNoOfCopies(){
        noOfCopies = parser.getCopierInfo(); 
    }

    public int getTemperature(){
        return -999;
    }

}

