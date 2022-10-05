import Backend.DispatchEngine;

public class Main {
    public static void main(String[] args) {
        DispatchEngine dispatchEngine = new DispatchEngine();
        dispatchEngine.start();     //change of plans. main will only do this. The rest is done by DispatchEngine class instance.
    }
}
