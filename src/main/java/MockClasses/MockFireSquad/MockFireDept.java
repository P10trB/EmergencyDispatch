package MockClasses.MockFireSquad;

import java.util.ArrayList;
import java.util.List;

import CommonClasses.EmergencyServiceType;
import Interfaces.IDispatchable;

public class MockFireDept implements IDispatchable {
    private int firemen;
    private final EmergencyServiceType emergencyServiceType = EmergencyServiceType.FIREFIGHTERS;

    private List<MockFireUnit> mockFireUnits;

    MockFireDept(){
        this(20);
    }

    MockFireDept(int firemen) {
        this.firemen = firemen;
        this.mockFireUnits = new ArrayList<>();
        buyBrandNewVehicles();
    }
    private void buyBrandNewVehicles(){
        mockFireUnits.add(new MockFireEngine());
        mockFireUnits.add(new MockFireEngine(1000));
        mockFireUnits.add(new MockFireTruck());
        mockFireUnits.add(new MockFireTruck());
        mockFireUnits.add(new MockTurntableLadderTruck());
        mockFireUnits.add(new MockTurntableLadderTruck(700.0));

    }
    @Override
    public List<String> dispatchUnits(String incident) {
        //TODO return real list
        List<MockFireUnit> unitsToBeDispatched = new ArrayList<>();
        List<String> sentUnitsList = new ArrayList<>();
        for(MockFireUnit unit : mockFireUnits){
            if(unit.getState().equals(MockFireUnit.State.READY)){   //only send units ready to be dispatched
                if(incident.contains("fire")){
                    if(unit.getClass().equals(MockFireEngine.class)){
                        unitsToBeDispatched.add(unit);
                        unit.go();
                    }
                    if(unit.getClass().equals(MockFireTruck.class)){
                        unitsToBeDispatched.add(unit);
                        ((MockFireTruck) unit).boardCrew(7);
                        unit.go();
                    }
                }
                else if(incident.equals("Car accident") && unit.getClass().equals(MockFireTruck.class)){
                    unitsToBeDispatched.add(unit);
                    ((MockFireTruck) unit).boardCrew(7);
                    unit.go();
                }
                else if(incident.startsWith("Cat") && unit.getClass().equals(MockTurntableLadderTruck.class)){
                    unitsToBeDispatched.add(unit);
                    unit.go();
                }
            }
        }
        for(MockFireUnit unit : unitsToBeDispatched){
            sentUnitsList.add(unit.getName());
        }
        return sentUnitsList;
    }

    @Override
    public EmergencyServiceType getType() {
        return null;
    }
}
