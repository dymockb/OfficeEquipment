package model;

public class Copier extends OfficeMachine {
		

	CopierJob job;
	/**
	 * Constructor for a Copier
	 */
	public Copier() {
		super();
		machineDesc = "Copier";
		machineType = "CPY";
		job = new CopierJob();
	}

	public void processJob(){
		System.out.println("processJob, getJob:" + getJob().getJobString());
		if(job != null){
			System.out.println("Job " + job.getJobString() + " copying...");
			System.out.println("no of copies " + job.getNoOfCopies());
			System.out.println("type " + job.getJobType());
			int noOfCopies = job.getNoOfCopies();
			int copiesDone = 1;
			while(copiesDone < noOfCopies){
				System.out.println("Copy " + copiesDone + " of " + noOfCopies + ":" + job.getJobDescription());	
				copiesDone++;
			}
			job = null;
		} else {
			System.out.println("Nothing to copy.");
		}

	}

	public Job getJob(){
		return job;
	}

	
}
