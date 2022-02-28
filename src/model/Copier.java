package model;

public class Copier extends OfficeMachine {
		
	/**
	 * Constructor for a Copier
	 */
	public Copier() {
		super();
		machineDesc = "Copier";
		machineType = "CPY";
	}

	public void processJob(){

		if(job != null){
			System.out.println("Job " + job.getJobString() + " copying...");
			
			//https://stackoverflow.com/questions/65323916/java-fails-to-recognize-that-i-am-declaring-the-subclass-and-cannot-find-member
			int noOfCopies = job.getNoOfCopies();
			
			int copiesDone = 1;
			while(copiesDone <= noOfCopies){
				System.out.println(" - Copy " + copiesDone + " of " + noOfCopies + ": " + job.getJobDescription());	
				copiesDone++;
			}
		
			job = null;
		
		} else {
			System.out.println("Nothing to copy.");
		}

	}
	
}
