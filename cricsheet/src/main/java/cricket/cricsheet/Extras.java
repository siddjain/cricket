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
    // If the ball is not struck by the batsman's bat (nor connects with any part of the
    // batsman's body) the batsmen may still run if they choose. If the ball reaches the 
    // boundary, whether or not the batsmen ran, four byes are awarded. Any runs scored are
    // tallied separately on the scorecard and do not count towards the batsman's individual 
    // score
    public int byes;
    // If the ball hits the batsman's body, then provided the batsman is not out leg before
    // wicket (lbw) and the batsman either tried to avoid being hit or tried to hit the ball 
    // with the bat, the batsmen may run. In this case, regardless of the part of anatomy 
    // touched by the ball, the runs scored are known as leg-byes. If (with the same provious) 
    // the ball reaches the boundary, whether or not the batsmen ran, then four leg-byes are
    // awarded.
    public int legbyes;
    // no-ball does not count as one of the six in an over and an extra ball is bowled.
    public int noballs;
    // a wide is not counted as one of the six balls in the over and a replacement is bowled
    public int wides;
    // Penalty runs are awarded for various breaches of the Laws, generally related to unfair
    // play or player conduct. Many of these penalties have been added since 2000. 
    public int penalty;
}