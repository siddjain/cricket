package cricket;

import java.io.*;
import cricket.cricsheet.*;

/**
 * Hello world!
 *
 */
public class App 
{
    // First unzip odis.zip folder
    // then Run this progrsm from cricsheet folder like:
    // mvn exec:java -Dexec.mainClass="cricket.App" -Dexec.args="../odis" > odi_stats.txt
    // It will output following stats:
    // Match_Inning 0s 1s 2s 3d 4s 5s 6s balls extras extra_balls wickets
    public static void main( String[] args )
    {
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
                        System.out.printf("%s %s\n", id, inning.stats.toString());                        
                    }
                }
            }
        }                
    }
}
