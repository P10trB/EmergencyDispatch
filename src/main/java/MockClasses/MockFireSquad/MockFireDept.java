package MockClasses.MockFireSquad;

import java.util.ArrayList;
import java.util.List;

import CommonClasses.EmergencyServiceType;
import Interfaces.IDispatchable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class MockFireDept implements IDispatchable {
    private final static int DEFAULT_CREW_NUMBER = 7;
    private int firemen;
    private final EmergencyServiceType emergencyServiceType = EmergencyServiceType.FIREFIGHTERS;

    private List<MockFireUnit> mockFireUnits = List.of(new MockFireEngine(), new MockFireEngine(1000),
            new MockFireTruck(), new MockFireTruck(), new MockTurntableLadderTruck());

    @Override
    public List<String> dispatchUnits(String incident) {
        List<MockFireUnit> unitsToBeDispatched = new ArrayList<>();
        List<String> sentUnitsList = new ArrayList<>();
        fireDeptInternalDispatchSystem(incident, unitsToBeDispatched);
        for (MockFireUnit unit : unitsToBeDispatched) {
            sentUnitsList.add(unit.getName());
        }
        return sentUnitsList;
    }

    private void fireDeptInternalDispatchSystem(String incident, List<MockFireUnit> unitsToBeDispatched) {
        for (MockFireUnit unit : mockFireUnits) {
            if (MockFireUnit.State.READY.equals(unit.getState())) {   //only send units ready to be dispatched
                if ((incident.contains("fire")) || (incident.equals("Car accident")) &&
                        (unit.getClass().equals(MockFireEngine.class) || (unit.getClass().equals(MockFireTruck.class)))) {
                    sendUnits(unitsToBeDispatched, unit);
                } else if (incident.startsWith("Cat") && unit.getClass().equals(MockTurntableLadderTruck.class)) {
                    sendUnits(unitsToBeDispatched, unit);
                }
            }
        }
    }




    private static void sendUnits(List<MockFireUnit> unitsToBeDispatched, MockFireUnit unit) {
        if(unit.getClass().equals(MockFireTruck.class)) {
            ((MockFireTruck) unit).boardCrew(DEFAULT_CREW_NUMBER);
        }
        unitsToBeDispatched.add(unit);
        unit.go();
    }

    @Override
    public EmergencyServiceType getType() {
        return emergencyServiceType;
    }
}
