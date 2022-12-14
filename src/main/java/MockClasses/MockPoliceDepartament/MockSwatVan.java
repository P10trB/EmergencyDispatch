package MockClasses.MockPoliceDepartament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class MockSwatVan extends MockSquadVehicle{
    MockSwatVan(String name){
        super.setName(name);
    }
    @Getter @Setter
    private int squadMembersOnBoard;
}
