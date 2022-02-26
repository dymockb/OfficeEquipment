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
		System.out.println("processJob, getJob:" + getThisJob().getJobString());
		System.out.println("class " + getJob().getClass());
		if(getJob() != null){
			//CopierJob jobToProcess = getJob();
			System.out.println("Job " + getJob().getJobString() + " copying...");
			//System.out.println("no of copies " + getJob().getNoOfCopies());
			int noOfCopies = getThisJob().getNoOfCopies();
			int copiesDone = 1;
			while(copiesDone < noOfCopies){
				System.out.println("Copy " + copiesDone + " of " + noOfCopies + ":" + getThisJob().getJobDescription());	
				copiesDone++;
			}
			job = null;
		} else {
			System.out.println("Nothing to copy.");
		}

	}

	private CopierJob getThisJob(){
		return this.job;
	}
	
}
