package cricket.cricsheet;

import java.util.*;

public class UglyCricSheet {
    public Meta meta;
    public Info info;
    public List<Map<String,UglyInning>> innings; 
    
    public CricSheet toCricSheet() {
        CricSheet result = new CricSheet();
        result.meta = meta;
        result.info = info;
        List<UglyInning> list = Util.flatten(innings);
        List<Inning>  innings = new ArrayList<>();
        for (UglyInning u : list) {
            innings.add(u.toInning());
        }
        result.innings = innings;
        return result;
    }    
}