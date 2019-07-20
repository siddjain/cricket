package cricket;

public class Probabilities {
    public double pZero;
    public double pOne;
    public double pTwo;
    public double pThree;
    public double pFour;
    public double pFive;
    public double pSix;
    public double pExtra;
    public double pOut;
    public double mean_extras;

    public Probabilities(Stats s) {
        int totalBalls = s.balls + s.extraBalls;
        pZero = (double) s.zeros / s.balls;
        pOne = (double) s.ones / s.balls;
        pTwo = (double) s.twos / s.balls;
        pThree = (double) s.threes / s.balls;
        pFour = (double) s.fours / s.balls;
        pFive = (double) s.fives / s.balls;
        pSix = (double) s.sixes / s.balls;
        pExtra = (double) s.extraBalls / (s.balls + s.extraBalls);
        pOut = (double) s.wickets / s.balls;
        // will equal NaN if no extra balls
        mean_extras = (double) s.extras / s.extraBalls;        
    }

    public String toString() {
        return String.format("%.4f %.4f %.4f %.4f %.4f %.4f %.4f %.4f %.4f %.4f",
            pZero, pOne, pTwo, pThree, pFour, pFive, pSix, pExtra, pOut, mean_extras);
    }
}