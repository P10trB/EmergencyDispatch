package MockClasses.MockMedicalService;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class MockAmbulance {
    public MockAmbulance(String name){
        this.name = name;
        Random random = new Random();
        canBeDispatched = random.nextBoolean();
    }
    @Getter
    private final String name;
    @Getter @Setter
    private boolean canBeDispatched;

    @Override
    public String toString() {
        return name;
    }
}
