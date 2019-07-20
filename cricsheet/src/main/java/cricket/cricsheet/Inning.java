package cricket.cricsheet;

import java.util.*;

import cricket.Stats;

public class Inning {
    public String team;
    public List<Delivery> deliveries;    
    public Stats stats;

    public void calcStats() {
        Stats stats = new Stats();
        for (Delivery d : deliveries) {
            int runs = d.runs.total;
            if (d.extras != null) {
                // we only count wides and no balls - those balls that need to be bowled again
                if (d.extras.noballs > 0 || d.extras.wides > 0) {
                    stats.extraBalls++;
                }
            } else {
                stats.balls++;
            }
            if (d.wicket != null) {
                stats.wickets++;
            }
            if (runs < stats.counts.length) {
                stats.counts[runs]++;                                  
            } else {
                throw new RuntimeException("total runs = " + runs + " is greater than max allowed");
            }
        }
        this.stats = stats;
    }
}