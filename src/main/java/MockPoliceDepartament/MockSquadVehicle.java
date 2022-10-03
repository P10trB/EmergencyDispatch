package MockPoliceDepartament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class MockSquadVehicle {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private boolean readyToDispatch;

    @Override
    public String toString() {
        return name;
    }
}
