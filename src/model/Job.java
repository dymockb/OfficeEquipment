package model;

/** 
 * This class holds information about a job that will be assigned to a machine.

 * @author  Dymock Brett
 * @version v1.0
 */

public class Job
{
    private String description;
    private String owner;
    private String code;

    /**
     */
    public Job(String code, String owner, String description)
    {
        this.description = description;
        this.owner = owner;
        this.code = code;
    }

    public String getDescription(){
        return description;
    }

    public String getOwner(){
        return owner;
    }

    public String getCode(){
        return code;
    }
}

