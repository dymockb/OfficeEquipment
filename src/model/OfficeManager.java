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
        managerCommands = new String[] {"stop", "add-jobs", "process-jobs", "queue", "help"};
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
        } else if (command.getCommandWord().equals("add-jobs")){
            boolean addingJobs = true;
            String stringOfMachineTypes = "";
            for (OfficeMachine om : availableMachines){
                stringOfMachineTypes += om.getType() + ", ";
            }
            String commandsToUse = stringOfMachineTypes.substring(0,stringOfMachineTypes.length()-2);
            while(addingJobs){
                System.out.println("- Enter: " + commandsToUse);
                System.out.println(" (If your job is not available make sure there is \n" + 
                                   " the right type of machine installed in the office.)");
                System.out.println("- Or enter 'done' to finish adding jobs.");
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

            //boolean processingJobs = true;
            //while(processingJobs){
    
                processJobs(jobQueue);

            //}

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

    public void processJobs(ArrayList<Job> jobQueue){
        
        if(jobQueue.size()>0){
            for(int j = 0; j < jobQueue.size(); j++){
                OfficeMachine om = findNextAvailableMachine(jobQueue.get(j));
                om.processJob();
                if(om.getType().equals("SCN")){
                    OfficeMachine printer = findNextAvailableMachine(om.getJob());
                    if(printer != null){
                        printer.processJob();
                    } else {
                        System.out.println("Can't find a printer to print Scan job.");
                    }

                }
                jobQueue.remove(j);
            }
        } else {
            System.out.println("** No jobs in queue.");
            //processingJobs = false;
        }  
    }

    private OfficeMachine findNextAvailableMachine(Job job){
        //OfficeMachine output = OfficeMachine.blankMachine();
        for(OfficeMachine om : availableMachines){
            if(job.getJobType().equals(om.getType())){
                if(assignJob(job, om)){
                    return om;
                } else {
                    continue;
                }
            }
        }
        return null;
        //return output;
    }


    private boolean assignJob(Job job, OfficeMachine machine){
        return machine.acceptJob(job);
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
                Job job = Job.createJob(jobType);

                int jobCode = createJobCode(jobCodes);
                job.setJobCode(jobCode);
                
                addToQueue(job);
                //jobQueue.add(job);
                return true;
            } else {
                System.out.println("The office does not contain any machines able to process that job.");
                return true;
            }
        }
    }

    public void addToQueue(Job job){
        jobQueue.add(job);
        System.out.println("* A new " + job.getJobType() + " job has been added to the queue. *");
    }

    public ArrayList<Job> getQueue(){
        return jobQueue;
    }

    public int createJobCode(ArrayList<Integer> jobCodes){
        int newCode = jobCodes.size() + 1;
        jobCodes.add(newCode);
        return newCode;
    }

    public ArrayList<Integer> getJobCodes(){
        return jobCodes;
    }
}

