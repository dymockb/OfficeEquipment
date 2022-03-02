package model;

public class FoodProcessor extends OfficeMachine {
		
	/**
	 * Constructor for a Printer
	 */
	int lowerBound = 12;
	int upperBound = 25;
	
	public FoodProcessor() {
		super();
		machineDesc = "FoodProcessor";
		machineType = "FPR";
	}

	public void processJob() throws TemperatureException {
		if(this.job != null){
			FoodProcessorJob foodJob = (FoodProcessorJob)job;
			if(foodJob.getTemperature() < lowerBound || foodJob.getTemperature() > upperBound){
				setErrorStatus(true);
				throw new TemperatureException(this.machineCode, lowerBound, upperBound, foodJob.getTemperature());
			} else {
				System.out.println("Job " + job.getJobString() + " blending breakfast...");
				System.out.println(" - " + job.getJobDescription());
				this.job = null;
			}

		} else {
			System.out.println("No food to process");
		}

	}
	
}
