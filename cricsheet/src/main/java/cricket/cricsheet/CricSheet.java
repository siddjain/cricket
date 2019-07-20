package cricket.cricsheet;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.yaml.*;

public class CricSheet {
    public Meta meta;
    public Info info;
    public List<Inning> innings;

    public static CricSheet readFromFile(String filename) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        // we have to use the flag below as our class declarations do not cover some fields 
        // such as Replacements defined at https://cricsheet.org/format/
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        UglyCricSheet result = null;
        try {
            result = mapper.readValue(new File(filename), UglyCricSheet.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result.toCricSheet();
    }
}