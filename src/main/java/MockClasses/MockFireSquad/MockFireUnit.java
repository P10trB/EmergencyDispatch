package MockClasses.MockFireSquad;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class MockFireUnit {

    @Getter @Setter
    State state;
    @Getter String name;

    protected List<String> tools;
    protected enum State{
        READY, BROKEN, ON_DISPATCH, BEING_REPAIRED, BEING_CLEANED, RETURNING_TO_BASE;
    }
    MockFireUnit(String name, State state, List<String> tools){
        this.name = name;
        this.state = state;
        this.tools = tools;
    }
    void go(){
        state = State.ON_DISPATCH;
        //log.info("Yes sir!");
        System.out.println(("Yes sir!"));
    }

    //more methods fire unit specific should be below
}