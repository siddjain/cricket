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

    public static Stats fromString(String str) {
        String[] tokens = str.split(" ");
        Stats s = new Stats();
        s.zeros = Integer.parseInt(tokens[0]);
        s.ones = Integer.parseInt(tokens[1]);
        s.twos = Integer.parseInt(tokens[2]);
        s.threes = Integer.parseInt(tokens[3]);
        s.fours = Integer.parseInt(tokens[4]);
        s.fives = Integer.parseInt(tokens[5]);
        s.sixes = Integer.parseInt(tokens[6]);
        s.balls = Integer.parseInt(tokens[7]);
        s.extras = Integer.parseInt(tokens[8]);
        s.extraBalls = Integer.parseInt(tokens[9]);
        s.wickets = Integer.parseInt(tokens[10]);
        return s;
    }
}