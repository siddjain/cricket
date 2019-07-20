package cricket.cricsheet;

// https://cricsheet.org/format/
public class Runs {
    // The total number of runs scored by the batsman off the ball.
    public int batsman;
    // The total number of runs conceded via extras off the ball
    public int extras;
    // The total number of runs scored off this delivery
    public int total;
    // If this is listed against the delivery then the value will be 1. 
    // This indicates that the 4 or 6 scored was not via an actual boundary.
    public int non_boundary;
}