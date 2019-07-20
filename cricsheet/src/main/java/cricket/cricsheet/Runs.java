package cricket.cricsheet;

public class Runs {
    public int batsman;
    public int extras;
    public int total;
    // If this is listed against the delivery then the value will be 1. 
    // This indicates that the 4 or 6 scored was not via an actual boundary.
    public int non_boundary;
}