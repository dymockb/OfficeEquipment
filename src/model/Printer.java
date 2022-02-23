package model;

//import model.OfficeMachine;

public class Printer extends OfficeMachine {
		
	/**
	 * Constructor for a Printer
	 */
	public Printer() {
		super();
		machineDesc = "Printer";
		machineCode = "PRT";
	}

	public void processJob(Job job){
		if(acceptJob(job)){
			this.job = job;
			System.out.println(job.getDescription());
			this.job = null;
		}

	}

	
}
