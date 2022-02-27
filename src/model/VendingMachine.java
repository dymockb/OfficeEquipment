package model;

public class VendingMachine extends OfficeMachine {
		
	/**
	 * Constructor for a Scanner
	 */
	public VendingMachine() {
		super();
		machineDesc = "Vending-machine";
		machineType = "VND";
	}

	public void processJob(){
		if(job != null){
			System.out.println("Job " + job.getJobString() + ": vending order...");
			String ownerNumber = String.valueOf(job.getJobOwner());			
			if(ownerNumber.charAt(0) == '1'){
				System.out.println("Manager account - no charge.");
				job = null;
			} else {
				System.out.println("Your account has been charged £0.10.");
				job = null;
			}

		} else {
			System.out.println("No vending machine orders.");
		}

	}
	
}
