package cricket;

import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.yaml.*;

public class Config {
    public double pZero;
    public double pOne;
    public double pTwo;
    public double pThree;
    public double pFour;
    public double pFive;
    public double pSix;
    public double pSeven;
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
        double[] p = new double[9];
        p[0] = pZero;
        p[1] = pOne;
        p[2] = pTwo;
        p[3] = pThree;
        p[4] = pFour;
        p[5] = pFive;
        p[6] = pSix;
        p[7] = pSeven;
        p[8] = pOut;
        return new Dice(p);
    }

    private void validate() {
        Util.checkBetweenZeroAndOne(pZero);
        Util.checkBetweenZeroAndOne(pOne);
        Util.checkBetweenZeroAndOne(pTwo);
        Util.checkBetweenZeroAndOne(pThree);
        Util.checkBetweenZeroAndOne(pFour);
        Util.checkBetweenZeroAndOne(pFive);
        Util.checkBetweenZeroAndOne(pSix);
        Util.checkBetweenZeroAndOne(pSeven);
        Util.checkBetweenZeroAndOne(pOut);
        Util.checkBetweenZeroAndOne(pNoBall);
        double sum = pZero + pOne + pTwo + pThree + pFour + pFive + pSix + pSeven + pOut;
        if (Math.abs(sum - 1.0) < 0.0001) {            
            pOut = 1.0 - (pZero + pOne + pTwo + pThree + pFour + pFive + pSix + pSeven);
        } else {
            throw new RuntimeException("probabilities do not sum to 1");
        }
    }
}