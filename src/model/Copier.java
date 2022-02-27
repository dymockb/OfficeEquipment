package model;

public class Copier extends OfficeMachine {
		

	//private CopierJob job ;
	//private int copiesForJob;
	/**
	 * Constructor for a Copier
	 */
	public Copier() {
		super();
		machineDesc = "Copier";
		machineType = "CPY";
		job = new CopierJob();
		//(CopierJob)job;
	}

	public void processJob(){
		//System.out.println(this.job.getClass());
		if(job != null){
			System.out.println("Job " + job.getJobString() + " copying...");
			System.out.println("Job class" + job.getClass());
			
			//https://stackoverflow.com/questions/65323916/java-fails-to-recognize-that-i-am-declaring-the-subclass-and-cannot-find-member
			int noOfCopies = job.getNoOfCopies();
			
			//int noOfCopies = 3; 
			int copiesDone = 1;
			while(copiesDone <= noOfCopies){
				System.out.println("Copy " + copiesDone + " of " + noOfCopies + ":" + job.getJobDescription());	
				copiesDone++;
			}
			
			
			job = null;
		} else {
			System.out.println("Nothing to copy.");
		}

	}
	
}
