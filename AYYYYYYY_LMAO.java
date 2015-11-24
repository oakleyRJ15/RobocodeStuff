package RJOakley;
import robocode.*;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * AYYYYYYY_LMAO - a robot by (your name here)
 */
public class AYYYYYYY_LMAO extends Robot
{
	/**
	 * run: AYYYYYYY_LMAO's default behavior
	 */
	public void run() {
	        setAdjustRadarForGunTurn(false);
			setAdjustRadarForRobotTurn(false);
			setAdjustGunForRobotTurn(true);
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnRight(45);
			turnGunRight(360);
			ahead(100);
			
		
	
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
public void onScannedRobot(ScannedRobotEvent e) {
		double absoluteBearing = getHeading() + e.getBearing();
		double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());

	
		if (Math.abs(bearingFromGun) <= 1) {
			turnGunRight(bearingFromGun);
		
			if (getGunHeat() == 0) {
				fire(Math.min(1 - Math.abs(bearingFromGun), getEnergy() - .1));
			}
		} 
		else {
			turnGunRight(bearingFromGun);
		}

		if (bearingFromGun == 0) {
			scan();
		}
	}
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(250);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(100);
		turnRight(90);
		ahead(100);
	}	
}
