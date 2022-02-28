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

			System.out.println(" - " + job.getJobDescription());
			System.out.println(" - Scan ready, converted to print job: " + job.getJobString());

		} else {
			System.out.println("Nothing to scan.");
		}

	}
	
}
