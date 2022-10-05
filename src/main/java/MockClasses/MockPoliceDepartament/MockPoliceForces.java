package MockClasses.MockPoliceDepartament;

import CommonClasses.EmergencyServiceType;
import Interfaces.IDispatchable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
public class MockPoliceForces implements IDispatchable {
    private final List<String>acceptableIncidents = Arrays.asList("Suicidal attempt", "Car accident", "Building fire");
    EmergencyServiceType emergencyServiceType = EmergencyServiceType.POLICE;
    MockSquadVehicle[] vehicles = {new MockSquadCar("Squad Car"), new MockSwatVan("SWAT Van"), new MockSquadCar("Squad Car"), new MockSquadCar("Squad Car")};
    @Override
    public List<String> dispatchUnits(String incident) {
        List<String> dispatchableUnits = new ArrayList<>();
        if(incident.equals("Bank robbery")){
            for(MockSquadVehicle vehicle : vehicles){
                if(vehicle.isReadyToDispatch()){
                    dispatchableUnits.add(vehicle.toString());
                }
            }
        }
        else if(acceptableIncidents.contains(incident)){
            for(MockSquadVehicle vehicle : vehicles){
                if(vehicle.isReadyToDispatch() && !vehicle.getClass().equals(MockSwatVan.class) && !dispatchableUnits.contains("Squad Car")){
                    dispatchableUnits.add(vehicle.toString());
                }
            }
        }
        else {
            dispatchableUnits.add("No Police units will be dispatched");
        }
        return dispatchableUnits;
    }

    @Override
    public EmergencyServiceType getType() {
        return emergencyServiceType;
    }
}
