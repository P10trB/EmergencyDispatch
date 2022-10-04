package IncidentFactory;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//IncidentCreator should be a singleton class.
public class IncidentCreator {
    private static IncidentCreator incidentCreator = null;
    private final Random random = new Random();
    @Getter
    List<Incident> incidentList;
    private IncidentCreator(){
        incidentList = new ArrayList<>();
    }
    public static IncidentCreator getInstance(){
        if(incidentCreator == null){
            incidentCreator = new IncidentCreator();
        }
        return incidentCreator;
    }
    public List<Incident> createIncidentList(){
        int iterations = random.nextInt(10);
        for (int i = 0; i < iterations; i++) {
            incidentList.add(new Incident(random.nextInt(40), random.nextInt(50)));
        }
    return incidentList;
    }
}
