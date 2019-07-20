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
            if (d.extras != null && (d.extras.noballs > 0 || d.extras.wides > 0)) {
                // we only count wides and no balls - those balls that need to be bowled again
                stats.extraBalls++;                
            } else {
                // penalty and byes, legbyes get counted as part of normal balls as these
                // do not need to be bowled again
                stats.balls++;
            }
            if (d.wicket != null) {
                stats.wickets++;                
            } else if (runs < stats.counts.length) {
                stats.counts[runs]++;                                  
            } else {
                throw new RuntimeException("total runs = " + runs + " is greater than max allowed");
            }
        }
        this.stats = stats;
    }
}