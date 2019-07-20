package cricket.cricsheet;

import java.util.*;

public class Util {
    public static <T> List<T> flatten(List<Map<String, T>> list) {
        int n = list.size();
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            Map<String, T> map = list.get(i);
            if (map.size() != 1) {
                throw new RuntimeException("bug in code");
            }
            for (T v : map.values()) {
                result.add(v);                                
            }
        }
        return result;
    }
}