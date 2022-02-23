package model;

import java.util.ArrayList;
import util.Parser;
/**
 * The office manager class handles assignment of jobs to machines in the office.
 * 
 * @author  Dymock Brett
 * @version v1.0
 */

public class OfficeManager
{

    private Parser parser;
    private ArrayList<OfficeMachine> availableMachines;
    private ArrayList<String> jobCodes;
    /**
     * 
     * @param 
     */
    public OfficeManager(ArrayList<OfficeMachine> availableMachines)
    {
        this.availableMachines = availableMachines;
        parser = new Parser();
    }

    /**
     * @return 
     */
    public void start(){
        System.out.println("Office manager started");
        boolean officeManagerRunning = true;
        while(officeManagerRunning){
            Command command = parser.getJobCommand();
            officeManagerRunning = processCommand(command);
        }
        System.out.println("The Office Manager is now offline");
    }

    private boolean processCommand(Command command){
        boolean officeManagerRunning = true;
        String jobType = command.getCommandWord();
        if(jobType.equals("PRT")){
            Job job = new Job("PRT", "owner", "description");
            System.out.println("new Job");
            for(OfficeMachine om : availableMachines){
                System.out.println("for om");
                if(om.getCode().equals(jobType)){
                    System.out.println("if getcode");
                    om.processJob(job);
                }
            }
        } else if (command.getCommandWord().equals("stop")){
            System.out.println("om stopped");
            officeManagerRunning = false;
        }

        return officeManagerRunning;
    };
}

