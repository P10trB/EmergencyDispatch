package MockFireSquad;

import CommonClasses.Strings;

import java.util.Arrays;
import java.util.List;

class MockFireEngine extends MockFireUnit {
    private final double MAX_WATER_TANK_CAPACITY = 2000.0;
    private double currentWaterTankCapacity;
    private boolean pumpIsTurnedOn;
    MockFireEngine(){
        super(Strings.FIRE_ENGINE, State.READY, Arrays.asList("Long hose", "Medium hose", "Short hose", "Narrow hose attachment",
                "Medium hose attachment", "4 x Gas mask")); // I really have no idea what should be there, as I am no fireman.);
        currentWaterTankCapacity = 0;
        pumpIsTurnedOn = false;
    }
    MockFireEngine(double currentWaterTankCapacity){
        this();
        this.currentWaterTankCapacity = Math.max(currentWaterTankCapacity, MAX_WATER_TANK_CAPACITY);
    }
    MockFireEngine(double currentWaterTankCapacity, List<String> tools){
        new MockFireEngine(currentWaterTankCapacity);
        super.tools = tools;
    }

    double getCurrentWaterTankCapacity() {
        return currentWaterTankCapacity;
    }

    void refillTheTank(double capacity){
        if(capacity <= 0) return;
        if(capacity <= MAX_WATER_TANK_CAPACITY) this.currentWaterTankCapacity = capacity;
    }

    boolean isPumpTurnedOn() {
        return pumpIsTurnedOn;
    }
    void switchPumpOnOff(){
        pumpIsTurnedOn =!isPumpTurnedOn();
    }

}