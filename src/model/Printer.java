package model;

public class Printer extends OfficeMachine {
		
	/**
	 * Constructor for a Printer
	 */
	public Printer() {
		super();
		machineDesc = "Printer";
		machineType = "PRT";
	}

	public void processJob(Job job){
		if(acceptJob(job)){
			this.job = job;
			System.out.println(job.getJobDescription());
			this.job = null;
		}

	}

	
}
