package cricket;

public class Stats {
    // counts of 0, 1, 2, 3, 4, 5, 6, 7
    // there are many cases in the data when total number of runs in a delivery is 7
    // due to a six plus a no ball e.g.
    public int[] counts = new int[8];
    public int balls;    
    // count of no balls and wides. these don't count and a replacement has to be bowled
    public int extraBalls;
    public int wickets;

    public String toString() {
        return String.format("%d %d %d %d %d %d %d %d %d %d %d",
         counts[0], counts[1], counts[2], counts[3], counts[4], counts[5], counts[6],
         counts[7], balls, extraBalls, wickets);
    }

    public static Stats fromString(String str) {
        String[] tokens = str.split(" ");
        Stats s = new Stats();
        int i = 0;
        for (i = 0; i < s.counts.length; i++) {
            s.counts[i] = Integer.parseInt(tokens[i]);
        }        
        s.balls = Integer.parseInt(tokens[i++]);
        s.extraBalls = Integer.parseInt(tokens[i++]);
        s.wickets = Integer.parseInt(tokens[i++]);
        return s;
    }
}