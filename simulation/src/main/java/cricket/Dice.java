package cricket;

public class Dice {
    private double[] p;
    private double[] runningSum;

    public Dice(double[] probabilities) {
        int n = probabilities.length;
        this.p = probabilities;
        this.runningSum = new double[n];
        for (int i = 0; i < n; i++) {
            Util.checkBetweenZeroAndOne(p[i]);
            double previousSum = 0;
            if (i > 0) {
                previousSum = runningSum[i - 1];
            }
            runningSum[i] = previousSum + p[i];
        }
        if (runningSum[n-1] != 1) {
            throw new RuntimeException("probabilities do not sum to 1");
        }
    }

    public int play() {
        double d = Math.random();
        for (int i = 0; i < runningSum.length; i++) {
            if (d < runningSum[i]) {
                return i;
            }
        }
        throw new RuntimeException("bug in code");
    }
}