package MockClasses.MockFireSquad;

import CommonClasses.MessageValuesForGui;

import java.util.ArrayList;
import java.util.List;

public class MockTurntableLadderTruck extends MockFireUnit {
    private final double LADDER_MAX_LENGTH = 500.0;
    private final double LADDER_MIN_LENGTH = 0.0;
    private final int LADDER_MAX_DEGREES_ROTATION = 359;
    private final int LADDER_MIN_DEGREES_ROTATION = 0;
    private double ladderLength;
    private int ladderRotation;

    MockTurntableLadderTruck(double ladderLength) {
        super(MessageValuesForGui.TURNTABLE_LADDER_TRUCK, State.READY, new ArrayList<>());
        this.ladderLength = ladderLength;
        this.ladderRotation = LADDER_MIN_DEGREES_ROTATION;
    }

    MockTurntableLadderTruck(){
       this(0);
    }

    MockTurntableLadderTruck(String name, State state, List<String> tools, double ladderLength, int ladderRotation) {
        super(name, state, tools);
        this.ladderLength = ladderLength;
        this.ladderRotation = ladderRotation;
    }

    double getLadderLength(){
        return  ladderLength;
    }
    void extendLadder(double length){
        ladderLength += length;
        if(ladderLength < LADDER_MIN_LENGTH){
            ladderLength = LADDER_MIN_LENGTH;
        }
        if(ladderLength > LADDER_MAX_LENGTH){
            ladderLength = LADDER_MAX_LENGTH;
        }
    }

    int getLadderRotation(){
        return ladderRotation;
    }
    void rotateLadder(int degrees){
        ladderRotation += degrees;
        if(ladderRotation < LADDER_MIN_DEGREES_ROTATION){
            ladderRotation = LADDER_MIN_DEGREES_ROTATION;
        }
        if(ladderRotation > LADDER_MAX_DEGREES_ROTATION){
            ladderRotation = LADDER_MAX_DEGREES_ROTATION;
        }
    }
}
