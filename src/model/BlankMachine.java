package model;

public class BlankMachine extends OfficeMachine {
		
	/**
	 * Constructor for a non-functioning blank machine
	 */
	public BlankMachine() {
		super();
		machineDesc = "BlankMachine";
		machineType = "BNK";
	}

	public void processJob(){
	
	}

	
}
