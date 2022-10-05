package MockClasses.MockFireSquad;

import CommonClasses.MessageValuesForGui;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class MockTurntableLadderTruck extends MockFireUnit {
    private final static double LADDER_MAX_LENGTH = 500.0;
    private final static double LADDER_MIN_LENGTH = 0.0;
    private final static int LADDER_MAX_DEGREES_ROTATION = 359;
    private final static int LADDER_MIN_DEGREES_ROTATION = 0;
    @Getter
    private double ladderLength;
    @Getter private int ladderRotation;

    MockTurntableLadderTruck(double ladderLength) {
        super(MessageValuesForGui.TURNTABLE_LADDER_TRUCK, State.READY, new ArrayList<>());
        this.ladderLength = ladderLength;
        this.ladderRotation = LADDER_MIN_DEGREES_ROTATION;
    }


    MockTurntableLadderTruck(String name, State state, List<String> tools, double ladderLength, int ladderRotation) {
        super(name, state, tools);
        this.ladderLength = ladderLength;
        this.ladderRotation = ladderRotation;
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
