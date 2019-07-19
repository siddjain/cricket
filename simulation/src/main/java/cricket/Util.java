package cricket;

public final class Util {
    public static void checkBetweenZeroAndOne(double x) {
        if (x < 0 || x > 1) {
            throw new RuntimeException("value is not between 0 and 1");
        }
    }
}