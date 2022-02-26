package model;

public class Copier extends OfficeMachine {
		

	private Job[] oneJob;
	/**
	 * Constructor for a Copier
	 */
	public Copier() {
		super();
		machineDesc = "Copier";
		machineType = "CPY";
		oneJob = new Job[1];
	}

	public void processJob(){
		System.out.println("getThisJob class:" + getThisJob().getClass());
		System.out.println("getThisJob noOfCopies:" + getThisJob().getJobDescription());
		System.out.println("getJob class: " + getJob().getClass());
		System.out.println("getJob noOfCopies: " + getJob().getJobDescription());
		if(getThisJob() != null){
			Job jobToProcess = getThisJob();
			System.out.println("Job " + jobToProcess.getJobDescription() + " copying...");
			//System.out.println("no of copies " + runMachineSpecificMethods());
			int noOfCopies = oneJob[0].getNoOfCopies();
			int copiesDone = 1;
			while(copiesDone < noOfCopies){
				System.out.println("Copy " + copiesDone + " of " + noOfCopies + ":" + jobToProcess.getJobDescription());	
				copiesDone++;
			}
			job = null;
		} else {
			System.out.println("Nothing to copy.");
		}

	}

	protected void setJob(Job job){
		oneJob[1] = job;
	}

	//public void setJobClass(){
	//	job = new CopierJob();
	//}

	private Job getThisJob(){
		return this.job;
	}

	
}
