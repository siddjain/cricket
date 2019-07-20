package cricket.cricsheet;

import java.util.*;

public class UglyInning {
    public String team;
    public List<Map<String, Delivery>> deliveries;  
    
    public Inning toInning() {
        Inning inning = new Inning();
        inning.team = this.team;
        inning.deliveries = Util.flatten(this.deliveries);
        inning.calcStats();
        return inning;
    }    
}