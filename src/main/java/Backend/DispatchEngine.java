package Backend;

import CommonClasses.EmergencyServiceType;
import IncidentFactory.Incident;
import IncidentFactory.IncidentCreator;
import Interfaces.IDispatchable;
import GUI.MainGUI;
import lombok.Getter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DispatchEngine{
    IncidentCreator incidentCreatorEngine = IncidentCreator.getInstance();

    @Getter private List<Incident> incidentList;

    private static List<IDispatchable> dispatchableUnits = new ArrayList<>();
    static MainGUI mainGUI = new MainGUI();
    public static class RequestDispatchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO implement it
            boolean[] checkboxesStatus = new boolean[3];
            for (int i = 0; i < checkboxesStatus.length; i++) {
                checkboxesStatus[i] = mainGUI.getCheckboxStatus(i);
            }
            for(IDispatchable dispatchable : dispatchableUnits){
                requestDispatch(checkboxesStatus, dispatchable);    //send proper type of services
            }
        }
    }

    private static void requestDispatch(boolean[] checkboxesStatus, IDispatchable dispatchable) {
        if(dispatchable.getType().equals(EmergencyServiceType.FIREFIGHTERS) && checkboxesStatus[0]){
            dispatchable.dispatchUnits(mainGUI.getCurrentlySelectedIncident());
        }
        if(dispatchable.getType().equals(EmergencyServiceType.MEDICAL) && checkboxesStatus[1]){
            dispatchable.dispatchUnits(mainGUI.getCurrentlySelectedIncident());
        }
        if(dispatchable.getType().equals(EmergencyServiceType.POLICE) && checkboxesStatus[2]){
            dispatchable.dispatchUnits(mainGUI.getCurrentlySelectedIncident());
        }
    }


    public void Start(){
        incidentList = incidentCreatorEngine.populateIncidentList();
        mainGUI.makeGUI(incidentList);
    }

}