package MockClasses.MockPoliceDepartament;

import CommonClasses.EmergencyServiceType;
import Interfaces.IDispatchable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class MockPoliceForces implements IDispatchable {
    EmergencyServiceType emergencyServiceType = EmergencyServiceType.POLICE;
    MockSquadVehicle[] vehicles = {new MockSquadCar("Squad Car"), new MockSWATVan("SWAT Van"), new MockSquadCar("Squad Car"), new MockSquadCar("Squad Car")};
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
        else if(incident.equals("Suicidal attempt") || incident.equals("Car accident") || incident.equals("Building fire")){
            for(MockSquadVehicle vehicle : vehicles){
                if(vehicle.isReadyToDispatch() && !vehicle.getClass().equals(MockSWATVan.class) && !dispatchableUnits.contains("Squad Car")){
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
