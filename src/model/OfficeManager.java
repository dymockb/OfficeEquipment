package model;

import java.util.ArrayList;

import util.MachineCodes;
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
    private ArrayList<Job> jobQueue;
    private String[] managerCommands;
    private MachineCodes machineCodes;
    /**
     * 
     * @param 
     */
    public OfficeManager(ArrayList<OfficeMachine> availableMachines)
    {
        this.availableMachines = availableMachines;
        parser = new Parser();
        jobQueue = new ArrayList<Job>();
        managerCommands = new String[] {"stop", "add-job", "process-jobs", "view-job-queue", "help"};
    }

    /**
     * @return 
     */
    public void start(){
        System.out.println("Office manager started.  Enter help for assistance.");
        boolean officeManagerRunning = true;
        while(officeManagerRunning){
            Command command = parser.getManagerCommand(managerCommands);
            officeManagerRunning = processCommand(command);
        }
        System.out.println("The Office Manager is now offline.  Type 'help' for assistance.");
    }

    private boolean processCommand(Command command){

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return true;
        }

        boolean officeManagerRunning = true;
        if (command.getCommandWord().equals("stop")){
            officeManagerRunning = false;
        } else if (command.getCommandWord().equals("add-job")){
            boolean addingJobs = true;
            while(addingJobs){
                System.out.println("Add a job type:");
                System.out.println("- Enter: PRT, CPY, SCN, VND");
                System.out.println("Or enter 'done'");
                Command jobCommand = parser.getJobCommand();
                addingJobs = processJobCommand(jobCommand);  
            }
            System.out.println("Finished adding jobs");
        } else if (command.getCommandWord().equals("view-job-queue")){
            System.out.println("There are " + jobQueue.size() + "jobs in the queue.");
            for(Job j : jobQueue){
                System.out.println(j.getJobType());
                System.out.println(j.getJobOwner());
                System.out.println(j.getJobDescription());
            }
        } else if (command.getCommandWord().equals("process-jobs")){
            System.out.println("Loop through jobs");
        } else if (command.getCommandWord().equals("help")){
            System.out.println("Available commands:");
            System.out.println(" - add-job: Add a job to the queue");
            System.out.println(" - view-job-queue: View jobs currently in queue (not processed)");
            System.out.println(" - process-jobs: Process all jobs in the queue.");
            System.out.println(" - help: view this help menu");
            System.out.println(" - stop: stop the office manager");            
        }

        return officeManagerRunning;
    }

    private boolean processJobCommand(Command command){

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return true;
        }

        String jobType = command.getCommandWord();
        
        if(jobType.equals("done")){
            return false;
        } else {
            Job job = Job.createJob(jobType);
            jobQueue.add(job);
            return true;
        }
        /*
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
        }
        */ 

    };

}

