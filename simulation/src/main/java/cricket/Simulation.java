package cricket;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
public class Simulation
{    

    public static void main( String[] args )
    {
        String file = args[0];
        int totalMatches = Integer.parseInt(args[1]);        
        Config config = Config.readFromFile(file);
        int numInnings = (int) Math.ceil(Math.sqrt(totalMatches * 2));
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.printf("Found %d cores\n", cores);
        // System.out.printf("ThreadId Innings Runs Wickets Overs\n", cores);
        Thread[] threads = new Thread[cores];
        Worker[] worker = new Worker[cores];
        AtomicInteger counter = new AtomicInteger();
        for (int i = 0; i < cores; i++) {
            worker[i] = new Worker(counter, numInnings, config, i);
            threads[i] = new Thread(worker[i]);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        // now do combinations of innings to simulate matches
        // this way we only have to play 100 innings to simulate 10,000 matches
        List<Score> scores = new ArrayList<Score>();
        for (int i = 0; i < cores; i++) {
            for (Score score : worker[i].scorecard) {
                scores.add(score);
            }
        }
        int n = scores.size();
        int nTies = 0;
        int nTotal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Score a = scores.get(i);
                Score b = scores.get(j);
                if (a.runs == b.runs) {
                    nTies++;
                }
                nTotal++;
            }
        }
        double pTie = (double) nTies / nTotal;
        System.out.printf("Prob. of tie = %d / %d = %.4f \n", nTies, nTotal, pTie);
    }
}
