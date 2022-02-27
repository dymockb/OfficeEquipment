package model;

/** 
 * This class holds information about a Printer job.

 * @author  Dymock Brett
 * @version v1.0
 */

public class StandardJob extends Job
{

    /** Constructor for a printer job
     */
    public StandardJob(String jobType, int owner, String description)
    {
        super();
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
    }

    public int getNoOfCopies(){
		return 0;
	}

}

