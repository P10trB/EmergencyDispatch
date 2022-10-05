package Backend;

import Interfaces.IDispatchable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Backend.DispatchEngine.*;

public class RequestDispatchListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean[] checkboxesStatus = new boolean[3];
        for (int i = 0; i < checkboxesStatus.length; i++) {
            checkboxesStatus[i] = mainGUI.getCheckboxStatus(i);
        }
        for(IDispatchable dispatchable : dispatchableServices){
            requestDispatch(checkboxesStatus, dispatchable);    //send proper type of services
        }
    }
}