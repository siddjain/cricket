package cricket;

import java.io.*;
import cricket.cricsheet.*;

public class CalcSummary {
    // First unzip odis.zip folder
    // then Run this progrsm from cricsheet folder like:
    // mvn exec:java -Dexec.mainClass="cricket.CalcSummary" -Dexec.args="../odis" > odi_summary.txt
    // It will output following stats:
    // Match_Inning runs wickets overs
    public static void main( String[] args ) {
        String dir = args[0];                
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        for (File f : listOfFiles) {            
            if (f.isFile() && f.getName().endsWith(".yaml")) {
                CricSheet data = CricSheet.readFromFile(f.getAbsolutePath());
                if (data.info.gender.equals("male") &&
                    data.info.match_type.equalsIgnoreCase("ODI")) {
                    Integer i = 0;    
                    for (Inning inning : data.innings) {
                        i++;
                        // https://stackoverflow.com/a/924519/147530
                        String name = f.getName().replaceFirst("[.][^.]+$", "");
                        String id = name + "_" + i.toString();
                        Stats stats = inning.stats;
                        System.out.printf("%s %d %d %.1f\n", id, stats.totalRuns, stats.wickets, 
                            (double) stats.balls / 6);       
                    }
                }
            }
        }
    }
}