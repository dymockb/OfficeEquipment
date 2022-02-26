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
    private ArrayList<Job> jobQueue;
    private String[] managerCommands;
    private ArrayList<Integer> jobCodes;
    /**
     * 
     * @param 
     */
    public OfficeManager(ArrayList<OfficeMachine> availableMachines)
    {
        this.availableMachines = availableMachines;
        parser = new Parser();
        jobQueue = new ArrayList<Job>();
        managerCommands = new String[] {"stop", "add-job", "process-jobs", "queue", "help"};
        jobCodes = new ArrayList<Integer>();
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
                System.out.println("- Enter job type: PRT, CPY, SCN, VND");
                System.out.println("- Or enter 'done'");
                Command jobCommand = parser.getJobCommand();
                addingJobs = processJobCommand(jobCommand);  
            }
            System.out.println("Finished adding jobs.  Enter a command:");
            System.out.println(" - process-jobs:  Process the job queue.");
            System.out.println(" - queue:  view the job queue.");
            System.out.println(" - help: view the help menu.");  

        } else if (command.getCommandWord().equals("queue")){

            System.out.println("There are " + jobQueue.size() + " jobs in the queue.");
            for(Job j : jobQueue){
                System.out.println(" - " + j.getJobString() + ", owner (employee number): " + j.getJobOwner());
            }
        } else if (command.getCommandWord().equals("process-jobs")){

            System.out.println("** Assigning jobs...");
            for(int j = 0; j < jobQueue.size(); j++){
                for(OfficeMachine om : availableMachines){
                    System.out.println("Job type: " + jobQueue.get(j).getJobType());
                    System.out.println("Machine type: " + om.getType());
                    if(jobQueue.get(j).getJobType().equals(om.getType())){
                        if(assignJob(jobQueue.get(j), om)){
                            System.out.println(" - Job " + jobQueue.get(j).getJobString() + " assigned to machine " + om.getMachineString());
                            System.out.println(om.getJob().getJobString());
                            jobQueue.remove(j);
                            om.processJob();
                        }
                        break;
                    } else {
                        System.out.println("Error");
                    }
                }
            }
            
            System.out.println("** Running jobs...");
            /*
            for(OfficeMachine om : availableMachines){
                System.out.println("machine running: " + om.getMachineString());
                Job checkJob = om.getJob();
                if(checkJob != null){
                    System.out.println("check job in machine: " + checkJob.getJobString());
                    System.out.println("class type" + checkJob.getClass());
                } else {
                    System.out.println("no job in this machine");
                }

                //System.out.println("no of copies: " + checkJob.getNoOfCopies());                
                om.processJob();     
            }
            */

            System.out.println("** Finished processing jobs.");
            System.out.println("Type a command, or 'help':");            
        
        } else if (command.getCommandWord().equals("help")){
            System.out.println("Available commands:");
            System.out.println(" - add-job: Add a job to the queue");
            System.out.println(" - queue: View jobs currently in queue (not processed)");
            System.out.println(" - process-jobs: Process all jobs in the queue.");
            System.out.println(" - help: view this help menu");
            System.out.println(" - stop: stop the office manager");            
        }

        return officeManagerRunning;
    }


    private boolean assignJob(Job job, OfficeMachine machine){
        boolean success;
        success = machine.acceptJob(job);
        return success;
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
            int machinesAvailable = 0;
            for(OfficeMachine om : availableMachines){
                if(om.getType().equals(jobType)){
                    machinesAvailable++;
                }
            }
            if (machinesAvailable > 0){
                int jobCode = createJobCode(jobCodes);
                Job job = Job.createJob(jobType);
                job.setJobCode(jobCode);
                jobQueue.add(job);
                System.out.println("* A new " + jobType + " job has been added to the queue. *");
                return true;
            } else {
                System.out.println("The office does not contain any machines able to process that job.");
                return true;
            }
        }
    }

    private int createJobCode(ArrayList<Integer> jobCodes){
        int newCode = jobCodes.size() + 1;
        jobCodes.add(newCode);
        return newCode;
    }
}

