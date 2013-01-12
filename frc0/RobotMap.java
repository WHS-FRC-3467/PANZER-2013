package org.usfirst.frc0;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Gamepad
	public static final int gamepad1 = 1;
	public static final int gamepad2 = 2;
	
	// following variables to use with the DriveBase subsystem.
	public static final int rightMotor1 = 2;
	public static final int rightMotor2 = 3;
	public static final int leftMotor1 = 5;
	public static final int leftMotor2 = 6;
	
	//Shooter
	public static final int shooterMotor1 = 7;
	public static final int shooterMotor2 = 8;
	public static final double speed1 = 0.65;
	public static final double speed2 = 0.73;
	public static final double speed3 = 0.79;
	public static final double speed4 = 1.0;
	
	//Rollers
	public static final int shooterRollerSpikePort = 2;
	public static final int armRollerSpikePort = 8;
	
	//Pneumatics
	public static final int compresserRelay = 1;
	public static final int preasureSwitch = 1;
	public static final int sole1Port = 1;
	public static final int sole2Port = 2;
	
	//Motor safety timeout
	public static final int motorSafteyTimeout = 5;
	
	//Arm
	public static final int armMotor = 4;
	public static final boolean isManual = false;
	public static final int armPot = 8;
	public static final int armPosBottom = 5;
	public static final int setPointRangeHigh = 5;
	
	public final static double Kd = 0;
	public final static double Kp = 0;
	public final static double Ki = 0;

}
