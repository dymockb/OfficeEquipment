package model;

import util.OfficeMachine;

public class Printer extends OfficeMachine {
		
	private String name;
	/**
	 * Constructor for a Printer
	 */
	public Printer() {
		super();
		name = "machineName";
		machineType = "PRT";
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
