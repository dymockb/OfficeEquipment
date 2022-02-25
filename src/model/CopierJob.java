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
    public CopierJob(String jobType, int owner, String description)
    {
        super();
        parser = new Parser();
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
        noOfCopies = parser.getCopierInfo();
    }

    public int getNoOfCopies(){
        return noOfCopies;
    }

}

