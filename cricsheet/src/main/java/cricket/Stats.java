package cricket;

public class Stats {
    public int zeros;
    public int ones;
    public int twos;
    public int threes;
    public int fours;
    public int fives;
    public int sixes;
    public int balls;
    public int extras;
    public int extraBalls;
    public int wickets;

    public String toString() {
        return String.format("%d %d %d %d %d %d %d %d %d %d %d",
         zeros, ones, twos, threes, fours, fives, sixes, balls, extras, extraBalls, wickets);
    }
}