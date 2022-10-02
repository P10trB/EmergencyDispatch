package IncidentFactory;

class Location {
    int x;
    int y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    Location(){
        this(10,15);
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
