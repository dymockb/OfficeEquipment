package model;

public class Scanner extends OfficeMachine {
		
	/**
	 * Constructor for a Scanner
	 */
	public Scanner() {
		super();
		machineDesc = "Scanner";
		machineType = "SCN";
	}

	public void processJob(){
		if(job != null){
			System.out.println("Job " + job.getJobString() + " scanning...");
			
			job.setJobOwner(machineCode);
			job.setJobType("PRT");
			System.out.println("Scan ready - job: " + job.getJobString());

		} else {
			System.out.println("Nothing to scan.");
		}

	}
	
}
