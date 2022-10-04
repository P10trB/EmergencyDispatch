package Backend;

import CommonClasses.EmergencyServiceType;
import IncidentFactory.Incident;
import IncidentFactory.IncidentCreator;
import Interfaces.IDispatchable;
import GUI.MainGUI;
import MockClasses.MockFireSquad.MockFireDept;
import MockClasses.MockMedicalService.MockMedicalDepartment;
import MockClasses.MockPoliceDepartament.MockPoliceForces;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DispatchEngine{
    IncidentCreator incidentCreatorEngine = IncidentCreator.getInstance();

    @Getter private List<Incident> incidentList;

    final static List<IDispatchable> dispatchableServices = new ArrayList<>(Arrays.asList(new MockFireDept(), new MockMedicalDepartment(), new MockPoliceForces()));
    static MainGUI mainGUI = new MainGUI();

    static void requestDispatch(boolean[] checkboxesStatus, IDispatchable dispatchable) {
        if((EmergencyServiceType.FIREFIGHTERS).equals(dispatchable.getType()) && checkboxesStatus[0]){
            dispatchable.dispatchUnits(mainGUI.getCurrentlySelectedIncident());
        }
        if((EmergencyServiceType.FIREFIGHTERS).equals(dispatchable.getType()) && checkboxesStatus[1]){
            dispatchable.dispatchUnits(mainGUI.getCurrentlySelectedIncident());
        }
        if((EmergencyServiceType.FIREFIGHTERS).equals(dispatchable.getType()) && checkboxesStatus[2]){
            dispatchable.dispatchUnits(mainGUI.getCurrentlySelectedIncident());
        }
    }

    public void start(){
        incidentList = incidentCreatorEngine.createIncidentList();
        mainGUI.makeGUI(incidentList);
    }

}
