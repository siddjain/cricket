package cricket;

import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.yaml.*;

public class Config {
    public double pZero;
    public double pOne;
    public double pTwo;
    public double pFour;
    public double pSix;
    public double pOut;
    public double pNoBall;

    public static Config readFromFile(String filename) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Config config = null;
        try {
            config = mapper.readValue(new File(filename), Config.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        config.validate();
        return config;
    }

    public Dice createDice() {
        double[] p = new double[7];
        p[0] = pZero;
        p[1] = pOne;
        p[2] = pTwo;
        p[3] = pFour;
        p[4] = pSix;
        p[5] = pOut;
        p[6] = pNoBall;
        return new Dice(p);
    }

    private void validate() {
        Util.checkBetweenZeroAndOne(pZero);
        Util.checkBetweenZeroAndOne(pOne);
        Util.checkBetweenZeroAndOne(pTwo);
        Util.checkBetweenZeroAndOne(pFour);
        Util.checkBetweenZeroAndOne(pSix);
        Util.checkBetweenZeroAndOne(pOut);
        Util.checkBetweenZeroAndOne(pNoBall);
        double sum = pZero + pOne + pTwo + pFour + pSix + pOut + pNoBall;
        if (Math.abs(sum - 1.0) < 0.00001) {
            pNoBall = 1.0 - (pZero + pOne + pTwo + pFour + pSix + pOut);
        } else {
            throw new RuntimeException("probabilities do not sum to 1");
        }
    }
}