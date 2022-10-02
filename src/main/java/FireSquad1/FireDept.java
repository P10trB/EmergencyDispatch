package FireSquad1;

import java.util.ArrayList;
import java.util.List;

import CommonClasses.EmergencyServiceType;
import Interfaces.IDispatchable;

public class FireDept implements IDispatchable {
    private int firemen;
    private final EmergencyServiceType emergencyServiceType = EmergencyServiceType.FIREFIGHTERS;

    private List<FireUnit> fireUnits;

    FireDept(){
        this(20);
    }

    FireDept(int firemen) {
        this.firemen = firemen;
        this.fireUnits = new ArrayList<>();
        buyBrandNewVehicles();
    }
    private void buyBrandNewVehicles(){
        fireUnits.add(new FireEngine());
        fireUnits.add(new FireEngine(1000));
        fireUnits.add(new FireTruck());
        fireUnits.add(new FireTruck());
        fireUnits.add(new TurntableLadderTruck());
        fireUnits.add(new TurntableLadderTruck(700.0));

    }
    @Override
    public List<String> dispatchUnits(String incident) {
        //TODO return real list
        List<FireUnit> unitsToBeDispatched = new ArrayList<>();
        List<String> sentUnitsList = new ArrayList<>();
        for(FireUnit unit : fireUnits){
            if(unit.getState().equals(FireUnit.State.READY)){   //only send units ready to be dispatched
                if(incident.contains("fire")){
                    if(unit.getClass().equals(FireEngine.class)){
                        unitsToBeDispatched.add(unit);
                        unit.go();
                    }
                    if(unit.getClass().equals(FireTruck.class)){
                        unitsToBeDispatched.add(unit);
                        ((FireTruck) unit).boardCrew(7);
                        unit.go();
                    }
                }
                else if(incident.equals("Car accident") && unit.getClass().equals(FireTruck.class)){
                    unitsToBeDispatched.add(unit);
                    ((FireTruck) unit).boardCrew(7);
                    unit.go();
                }
                else if(incident.startsWith("Cat") && unit.getClass().equals(TurntableLadderTruck.class)){
                    unitsToBeDispatched.add(unit);
                    unit.go();
                }
            }
        }
        for(FireUnit unit : unitsToBeDispatched){
            sentUnitsList.add(unit.getName());
        }
        return sentUnitsList;
    }

    @Override
    public EmergencyServiceType getType() {
        return null;
    }
}
