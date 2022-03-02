package controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import model.OfficeMachine;
import model.OfficeManager;
import model.Listener;
import model.ListenerException;
import util.Parser;

public class OfficeTest {

    Office office;
    Parser parser = null;

    /** 
     * Test for ListenerException if listener is not registered on machine,
     * and that no exception thrown if listener is registered.
     * */
    @Test
    void ListenerExceptionTest() {
        Office office = new Office();

        //create a printer, set machine code and notifications array
    	OfficeMachine printer = office.createMachine("PRT");
        printer.setCode(office.createCode());
        printer.setNotifications();

        //add printer to the office
        office.addToInventory(printer);

        //start the manager 
        OfficeManager manager = new OfficeManager(office.getInventory(), parser);
        //Listener listener = new Listener(manager);

        //set online status before listener registered
        office.getInventory().get(0).setOnlineStatus(true);

        //check that a Listener exception is thrown if notification is sent
        String[] notifications = office.getInventory().get(0).getNotifications();
        assertThrows(ListenerException.class, 
                    ()->{ 
                        office.getInventory().get(0).notifyListener(notifications);
                    });       

        //register the listener in the printer machine
        Listener listener = new Listener(manager);
        office.getInventory().get(0).registerListener(listener);

        //check that an exception is now not thrown by the notification
        assertDoesNotThrow(()->{ 
            office.getInventory().get(0).notifyListener(notifications);
        });

    }

}
