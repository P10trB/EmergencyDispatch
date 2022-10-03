package IncidentFactory;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Incident{
    private final int MINIMUM_ASSISTANCE = 0;
    private final int MAXIMUM_ASSISTANCE = 7;
    Random random = new Random();
    private final static String[] NAMES = {"Forrest fire", "Building fire", "Cat on a tree", "Suicidal attempt", "Bank robbery", "Car accident"};
    @Getter String incidentName;
    boolean[] assumedAssistanceNeeded = new boolean[3];
    @Getter Location incidentLocation;
    @Getter Integer incidentHazardLevel;
    Incident(){
        this(15, 23);
    }
    Incident(int x, int y){
        incidentName = NAMES[random.nextInt(NAMES.length)];
        for(boolean assistanceNeeded : assumedAssistanceNeeded){
            assistanceNeeded = random.nextBoolean();
        }
        incidentLocation = new Location(x, y);
        incidentHazardLevel = random.nextInt(9);
    }

    @Override
    public String toString() {
        return "Incident " + incidentName + '\'' +
                ", location: " + incidentLocation +
                ", hazard level: " + incidentHazardLevel;
    }
}
