package MockClasses.MockFireSquad;

import CommonClasses.MessageValuesForGui;

import java.util.ArrayList;

public class MockFireTruck extends MockFireUnit {
    private final static int MAX_CREW_CAPACITY = 10;
    private  final static int INITIAL_CREW = 0;
    private int currentCrewOnBoard;

    MockFireTruck(){
        super(MessageValuesForGui.FIRE_TRUCK, State.READY, new ArrayList<>());
        this.currentCrewOnBoard = INITIAL_CREW;
    }
    int boardCrew(int crewMembers){
        currentCrewOnBoard += crewMembers;
        if(crewMembers < 0 && currentCrewOnBoard < 0){
            currentCrewOnBoard = 0; //can't have negative number of crew members
            return -crewMembers;     //return back the crew members to base
        }
        if(crewMembers > MAX_CREW_CAPACITY){
            currentCrewOnBoard = MAX_CREW_CAPACITY;
            return crewMembers - MAX_CREW_CAPACITY; //return crew members that didn't fit
        }
        return INITIAL_CREW;       //All crewmen have been sent, so no one left to return to base
    }
}
