package MockClasses.MockMedicalService;

import CommonClasses.EmergencyServiceType;
import Interfaces.IDispatchable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@AllArgsConstructor @NoArgsConstructor
public class MockMedicalDepartment implements IDispatchable {
    private static final List<String> excludedIncidents = Arrays.asList("Forrest fire", "Cat on a tree"); //Zmiana kosmetyczna
    List<MockAmbulance> mockAmbulanceList = Arrays.asList(new MockAmbulance("R"), new MockAmbulance("S"), new MockAmbulance("L"));
    EmergencyServiceType emergencyServiceType = EmergencyServiceType.MEDICAL;
    @Override
    public List<String> dispatchUnits(String incident) {
        List<String> unitsToBeSent = new ArrayList<>();
        if(!excludedIncidents.contains(incident)){      //Myślę, że tak wygląda dużo lepiej niż wcześniej.
            for (MockAmbulance ambulance : mockAmbulanceList){
                if(ambulance.isCanBeDispatched()){
                    unitsToBeSent.add(ambulance.toString());
                    break;
                }
            }
        }else {
            unitsToBeSent.add("No medical staff will be sent");
        }
        return unitsToBeSent;
    }

    @Override
    public EmergencyServiceType getType() {
        return emergencyServiceType;
    }
}
