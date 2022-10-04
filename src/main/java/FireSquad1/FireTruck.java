package FireSquad1;

import CommonClasses.Strings;

import java.util.ArrayList;

public class FireTruck extends FireUnit{
    private final int MAX_CREW_CAPACITY = 10;
    private  final int INITIAL_CREW = 0;
    private int currentCrewOnBoard;

    FireTruck(){
        super(Strings.FIRE_TRUCK, State.READY, new ArrayList<>());
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
        return 0;       //All crewmen have been sent, so no one left to return to base
    }
}
