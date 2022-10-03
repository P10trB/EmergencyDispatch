package MockClasses.MockMedicalService;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class MockAmbulance {
    private Random random = new Random();
    public MockAmbulance(String name){
        this.name = name;
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
