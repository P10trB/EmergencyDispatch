package PoliceDepartament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class MockSWATVan extends MockSquadVehicle{
    MockSWATVan(String name){
        super.setName(name);
    }
    @Getter @Setter
    private int squadMembersOnBoard;
}
