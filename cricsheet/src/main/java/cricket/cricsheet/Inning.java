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
            if (d.extras != null) {
                stats.extraBalls++;
                stats.extras += d.runs.extras;
            } else {
                stats.balls++;
                if (d.wicket != null) {
                    stats.wickets++;
                } else if (d.runs.batsman == 0) {
                    stats.zeros++;
                } else if (d.runs.batsman == 1) {
                    stats.ones++;
                } else if (d.runs.batsman == 2) {
                    stats.twos++;
                } else if (d.runs.batsman == 3) {
                    stats.threes++;
                } else if (d.runs.batsman == 4) {
                    stats.fours++;
                } else if (d.runs.batsman == 5) {
                    stats.fives++;
                } else if (d.runs.batsman == 6) {
                    stats.sixes++;
                }
            }            
        }
        this.stats = stats;
    }
}