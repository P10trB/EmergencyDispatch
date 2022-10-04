package IncidentFactory;
import lombok.Getter;

import java.util.Random;
public class Incident{
    private final static String[] NAMES = {"Forrest fire", "Building fire", "Cat on a tree", "Suicidal attempt", "Bank robbery", "Car accident"};
    @Getter private final String incidentName;
    @Getter private final Location incidentLocation;
    @Getter private final Integer incidentHazardLevel;

    Incident(int x, int y){
        Random random = new Random();
        incidentName = NAMES[random.nextInt(NAMES.length)];
        incidentLocation = new Location(x, y);
        incidentHazardLevel = random.nextInt(8) + 1;
    }

    public String getIncidentDescription(){
        StringBuilder builder = new StringBuilder();
        builder.append("CAUTION!\n");
        builder.append("Incident: ");
        builder.append(incidentName);
        builder.append(".\n");
        builder.append("Location coordinates of where it happened: ");
        builder.append(incidentLocation.toString());
        builder.append(".\n Incident hazard level is: ");
        builder.append(incidentHazardLevel);
        builder.append(".");
        return builder.toString();
    }
    @Override
    public String toString() {
        return "Incident " + incidentName + '\'' +
                ", hazard level: " + incidentHazardLevel;
    }
}
