package cricket;

public class Probabilities {
    // probability of runs - 0 to 7 in a ball
    public double[] pRuns = new double[8];
    // probability of getting out
    public double pOut;
    // probability of a wide or no-ball
    public double pNoBall;

    public Probabilities(Stats s) {        
        int totalBalls = s.balls + s.extraBalls;
        for (int i = 0; i < s.counts.length; i++) {
            pRuns[i] = (double) s.counts[i] / totalBalls;
        }
        pOut = (double) s.wickets / totalBalls;        
        pNoBall = (double) s.extraBalls / totalBalls;        
    }

    public String toString() {
        double sum = 0;
        for (int i = 0; i < pRuns.length; i++) {
            sum += pRuns[i];
        }
        sum += pOut;
        return String.format("%.4f %.4f %.4f %.4f %.4f %.4f %.4f %.4f %.4f %.4f %.4f",
            pRuns[0], pRuns[1], pRuns[2], pRuns[3], pRuns[4], pRuns[5], pRuns[6], 
            pRuns[7], pOut, pNoBall, sum);
    }
}