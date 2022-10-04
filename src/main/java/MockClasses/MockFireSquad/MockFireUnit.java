package MockClasses.MockFireSquad;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

class MockFireUnit {

    @Getter @Setter
    State state;
    @Getter String name;

    protected List<String> tools;
    protected enum State{
        READY, BROKEN, ON_DISPATCH, BEING_REPAIRED, BEING_CLEANED, RETURNING_TO_BASE;
    }
    MockFireUnit(){
        name = "Fire unit";
        state = State.READY;
        tools = new ArrayList<>();
    }
    MockFireUnit(String name, State state, List<String> tools){
        this.name = name;
        this.state = state;
        this.tools = tools;
    }
    void go(){
        state = State.ON_DISPATCH;
        System.out.println("Yes sir!");
    }

    //more methods fire unit specific should be below
}