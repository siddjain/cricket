package cricket;

public class Inning {
    public static final int NUM_BALLS = 300;

    private Config config;
    // number of runs scored
    private int runs;
    // number of wickets lost
    private int wickets;
    // number of balls played
    private int balls;
    private Dice dice;

    public Inning(Config config) {
        this.config = config;
        this.dice = config.createDice();
    }

    public void play() {
        while (this.balls < NUM_BALLS && this.wickets < 10) {
            bowl();      
        }
    }

    public Score getScore() {
        Score score = new Score();
        score.runs = runs;
        score.wickets = wickets;
        score.balls = balls;
        return score;
    }    

    private void bowl() {
        int i = dice.roll();
        if (i < 8) {
            this.runs += i;
        } else {
            this.wickets++;
        }
        if (Math.random() >= config.pNoBall) {
            this.balls++;
        }        
    }    
}