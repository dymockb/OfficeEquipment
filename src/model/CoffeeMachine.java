package model;

public class CoffeeMachine extends OfficeMachine {
		
	/**
	 * Constructor for a Scanner
	 */
	public CoffeeMachine() {
		super();
		machineDesc = "Coffee-machine";
		machineType = "CFE";
	}

	public void processJob(){
		if(job != null){
			System.out.println("Job " + job.getJobString() + ": vending coffee...");
			String ownerNumber = String.valueOf(job.getJobOwner());			
			if(ownerNumber.charAt(0) == '1'){
				System.out.println(" - Manager account - no charge.");
				job = null;
			} else {
				System.out.println(" - Your account has been charged £0.10.");
				job = null;
			}

		} else {
			System.out.println("No coffee orders.");
		}

	}
	
}
