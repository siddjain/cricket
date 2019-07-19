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
        switch (dice.play()) {
            case 6:
                // no ball; in this case a run might still be scored
                // do that quick-and-dirty
                playNoBall();
                return; 
            case 0:
                break;  // no run
            case 1:
                this.runs += 1;
                break;
            case 2:
                this.runs += 2;
                break;
            case 3:
                this.runs += 4;
                break;
            case 4:
                this.runs += 6;
                break;
            case 5:
                this.wickets++; // out!
                break;
            default:
                throw new RuntimeException("bug in code");
        }
        this.balls++;
    }

    private void playNoBall() {
        // runs will be scored but no wicket can be claimed
      switch (dice.play()) {
        case 0:
            break;  // no run
        case 1:
            this.runs += 1;
            break;
        case 2:
            this.runs += 2;
            break;
        case 3:
            this.runs += 4;
            break;
        case 4:
            this.runs += 6;
            break;
        }
    }
}