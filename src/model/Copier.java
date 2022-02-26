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
		this.job = new CopierJob();
	}

	public void processJob(){
		if(job != null){
			System.out.println("Job " + job.getJobString() + " copying...");
			int noOfCopies = job.getNoOfCopies();
			int copiesDone = 1;
			while(copiesDone != noOfCopies){
				System.out.println("Copy " + copiesDone + " of " + noOfCopies + ":" + job.getJobDescription());	
				copiesDone++;
			}
			job = null;
		} else {
			System.out.println("Nothing to copy.");
		}

	}

	
}
