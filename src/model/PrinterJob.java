package model;

/** 
 * This class holds information about a Printer job.

 * @author  Dymock Brett
 * @version v1.0
 */

public class PrinterJob extends Job
{

    /** Constructor for a printer job
     */
    public PrinterJob(String jobType, String owner, String description)
    {
        super();
        this.jobType = jobType;
        this.owner = owner;
        this.description = description;
    }

}

