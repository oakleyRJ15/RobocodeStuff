package RJOakley;
import robocode.*;
import java.awt.Color;
import robocode.util.Utils;
// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Test - a robot by (your name here)
 */
public class LAX_IS_LYFE extends Robot
{
	/**
	 * run: Test's default behavior
	 */
public void run() {
    // ...
 
    do {
        // ...
        // Turn the radar if we have no more turn, starts it if it stops and at the start of round
        if ( getRadarTurnRemaining() == 0.0 )
            setTurnRadarRightRadians( Double.POSITIVE_INFINITY );
        execute();
    } while ( true );
 
    // ...
}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
public void onScannedRobot(ScannedRobotEvent e) {
    // ...
 
    // Absolute angle towards target
    double angleToEnemy = getHeadingRadians() + e.getBearingRadians();
 
    // Subtract current radar heading to get the turn required to face the enemy, be sure it is normalized
    double radarTurn = Utils.normalRelativeAngle( angleToEnemy - getRadarHeadingRadians() );
 
    // Distance we want to scan from middle of enemy to either side
    // The 36.0 is how many units from the center of the enemy robot it scans.
    double extraTurn = Math.min( Math.atan( 36.0 / e.getDistance() ), Rules.RADAR_TURN_RATE_RADIANS );
 
    // Adjust the radar turn so it goes that much further in the direction it is going to turn
    // Basically if we were going to turn it left, turn it even more left, if right, turn more right.
    // This allows us to overshoot our enemy so that we get a good sweep that will not slip.
    radarTurn += (radarTurn < 0 ? -extraTurn : extraTurn);
 
    //Turn the radar
    setTurnRadarRightRadians(radarTurn);
 
    // ...
}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
