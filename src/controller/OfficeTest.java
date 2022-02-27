package controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import model.OfficeMachine;
import model.OfficeManager;
import model.Job;
import model.Printer;
import model.StandardJob;
import model.CopierJob;

public class OfficeTest {

    Office office;

    //a general test using each type of machine /job once
    @Test
    void testMain() {
        Office office = new Office();
    	OfficeMachine printer = office.createMachine("PRT");
        office.addToInventory(printer);
    	OfficeMachine copier = office.createMachine("CPY");
        office.addToInventory(copier);
    	OfficeMachine scanner = office.createMachine("SCN");
        office.addToInventory(scanner);        
    	OfficeMachine coffeeMachine = office.createMachine("CFE");
        office.addToInventory(coffeeMachine);
    	OfficeMachine vendingMachine = office.createMachine("VND");
        office.addToInventory(vendingMachine);

        //start the manager with all the machines installed in the office
        OfficeManager manager = new OfficeManager(office.getInventory());
        
        //create jobs
        //test that job codes increment with each job.
        Job printerJob = new StandardJob("PRT", 1, "testPrintJob");
        printerJob.setJobCode(manager.createJobCode(manager.getJobCodes()));        
        assertEquals(manager.getJobCodes().get(0), 1);

        Job copierJob = new CopierJob("CPY", 1, "testCopyJob", 3);
        copierJob.setJobCode(manager.createJobCode(manager.getJobCodes()));        
        assertEquals(manager.getJobCodes().get(1), 2);

        Job scannerJob = new StandardJob("SCN", 1, "testScannerJob");
        scannerJob.setJobCode(manager.createJobCode(manager.getJobCodes()));        
        assertEquals(manager.getJobCodes().get(2), 3);

        //add jobs to manager queue
        manager.addToQueue(printerJob);
        manager.addToQueue(copierJob);
        manager.addToQueue(scannerJob);

        OfficeMachine om = manager.findNextAvailableMachine(printerJob);
        assertTrue(om instanceof Printer);
        assertTrue(om.getJob() instanceof StandardJob);
        om.processJob();
        assertNull(om.getJob());     
    }
}
