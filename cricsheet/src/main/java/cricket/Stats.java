package cricket;

public class Stats {
    // counts of 0, 1, 2, 3, 4, 5, 6, 7
    // there are many cases in the data when total number of runs in a delivery is 7
    // due to a six plus a no ball e.g.
    public int[] counts = new int[8];
    public int balls;    
    // count of no balls and wides. these are the balls that don't count and a replacement
    // has to be bowled
    public int extraBalls;
    public int wickets;
    // this field was added later to the class when I wanted to plot histogram of total runs
    // and compare it to the model
    public int totalRuns;

    public String toString() {
        // we do not print out the total runs here - and do NOT change the code to do that
        // as it will result in a cascade of changes required
        return String.format("%d %d %d %d %d %d %d %d %d %d %d",
         counts[0], counts[1], counts[2], counts[3], counts[4], counts[5], counts[6],
         counts[7], balls, extraBalls, wickets);
    }

    public static Stats fromString(String str) {
        // note that the totalRuns will not be set
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