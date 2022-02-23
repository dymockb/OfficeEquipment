package model;

//import model.OfficeMachine;

public class Printer extends OfficeMachine {
		
	private String name;
	private Job job;
	/**
	 * Constructor for a Printer
	 */
	public Printer() {
		super();
		machineDesc = "Printer";
		machineCode = "PRT";
	}

	public void processJob(){
		System.out.println("Printing");
	}
	
	/**
	 * Factory method to build an Item object according to
	 * the CREATION_PROBABILITY. Returns null if chance so determines.
	 * @return The Item object, or null

	public static Item buildItem() {
		if(rng.nextDouble() <= CREATION_PROB) {
			return new Item();
		}
		return null;
	}
	 */

	/** 
	 * @return The machine name
	 */
	public String getName() {
		return name;
	}
	
}
