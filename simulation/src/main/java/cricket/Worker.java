package cricket;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Worker implements Runnable {
    private AtomicInteger ctr;
    private int totalCount;
    private Config config;
    private int threadId;
    public List<Score> scorecard;

    public Worker(AtomicInteger counter, int totalCount, Config config, int id) {
        this.ctr = counter;
        this.totalCount = totalCount;
        this.config = config;
        this.threadId = id;
        this.scorecard = new ArrayList<Score>();
    }

    public void run() {
        while (this.ctr.getAndIncrement() < totalCount) {
            int i = this.ctr.get();
            Inning inning = new Inning(config);
            inning.play();
            Score score = inning.getScore();
            // System.out.printf("%d %d %d %d %.1f\n", threadId, i, score.runs, score.wickets, (double) score.balls / 6);
            scorecard.add(score);
        }
    }
}