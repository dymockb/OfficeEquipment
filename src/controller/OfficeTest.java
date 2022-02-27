package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.OfficeMachine;
import model.OfficeManager;
import model.Job;

public class OfficeTest {

    Office office;

    //a general test using each type of machine /job once
    @Test
    void testMain() {
        Office office = new Office();
    	OfficeMachine printer = office.createMachine("PRT");
        office.addToInventory(printer);
        OfficeManager manager = new OfficeManager(office.getInventory());
        Job printerJob = Job.createJob("PRT");
        printerJob.setJobCode(manager.createJobCode(manager.getJobCodes()));
        
        assertEquals(manager.getJobCodes().get(0), 1);

        manager.addToQueue(printerJob);

        manager.processJobs(manager.getQueue());
    }
}
