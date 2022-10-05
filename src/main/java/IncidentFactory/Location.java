package IncidentFactory;

class Location {
    private final int X;
    private final int Y;
    Location(int x, int y){
        this.X = x;
        this.Y = y;
    }
    @Override
    public String toString() {
        return X + ", " + Y;
    }
}
