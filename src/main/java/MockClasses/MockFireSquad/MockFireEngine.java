package MockClasses.MockFireSquad;

import CommonClasses.MessageValuesForGui;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

class MockFireEngine extends MockFireUnit {
    private final static double MAX_WATER_TANK_CAPACITY = 2000.0;
    @Getter
    private double currentWaterTankCapacity = 0;
    @Getter private boolean pumpIsTurnedOn;
    MockFireEngine(){
        super(MessageValuesForGui.FIRE_ENGINE, State.READY, Arrays.asList("Long hose", "Medium hose", "Short hose", "Narrow hose attachment",
                "Medium hose attachment", "4 x Gas mask")); // I really have no idea what should be there, as I am no fireman.);
    }
    MockFireEngine(double currentWaterTankCapacity){
        this();
        this.currentWaterTankCapacity = max(currentWaterTankCapacity, MAX_WATER_TANK_CAPACITY);
    }
    MockFireEngine(double currentWaterTankCapacity, List<String> tools){
        new MockFireEngine(currentWaterTankCapacity);
        super.tools = tools;
    }

    void refillTheTank(double capacity){
        if(capacity <= 0) return;
        if(capacity <= MAX_WATER_TANK_CAPACITY) this.currentWaterTankCapacity = capacity;
    }

    void switchPumpOnOff(){
        pumpIsTurnedOn = isPumpIsTurnedOn();
    }

}
