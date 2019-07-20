package cricket;

import java.io.*;

public class CalcProb {
    // run from cricsheet folder:
    // mvn exec:java -Dexec.mainClass="cricket.CalcProb" -Dexec.args="odi_stats.txt" > odi_prob.txt
    public static void main( String[] args ) {
        try {
            String filename = args[0];
            BufferedReader br = new BufferedReader(new FileReader(filename)); 
            String st; 
            while ((st = br.readLine()) != null) {
                int i = st.indexOf(' ');
                String id = st.substring(0, i);
                Stats stats = Stats.fromString(st.substring(i + 1));   
                Probabilities p = new Probabilities(stats);
                System.out.printf("%s %s\n", id, p.toString());                             
            }            
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}