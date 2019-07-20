package cricket.cricsheet;

// https://cricsheet.org/format/
/*
    If extras were conceded from this delivery then this will indicate how the extras came about.
    The value of the field will be an associative array with byes, legbyes, noballs, penalty, and
    wides as the possible keys, and the associated value for each will be the number of runs from
    each
    https://en.wikipedia.org/wiki/Extra_(cricket)
*/
public class Extras {
    public int byes;
    public int legbyes;
    // no-ball does not count as one of the six in an over and an extra ball is bowled.
    public int noballs;
    // a wide is not counted as one of the six balls in the over and a replacement is bowled
    public int wides;
    public int penalty;
}