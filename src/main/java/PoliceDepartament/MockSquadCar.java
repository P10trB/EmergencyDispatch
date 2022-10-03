package PoliceDepartament;

import lombok.*;

@NoArgsConstructor
public class MockSquadCar extends MockSquadVehicle {
    MockSquadCar(String name){
        super.setName(name);
    }
    @Getter @Setter
    private boolean onAJob;

    public void setOnAJob(boolean onAJob) {
        if(super.isReadyToDispatch()){
            setOnAJob(true);
            setReadyToDispatch(false);
        }
        else{
            setOnAJob(false);
            setReadyToDispatch(true);
        }
    }
}
