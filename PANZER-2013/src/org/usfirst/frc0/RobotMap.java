package org.usfirst.frc0;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides flexibility changing wiring, makes checking the wiring easier and significantly
 * reduces the number of magic numbers floating around.
 */
public class RobotMap {
	// I AM THE SUPREAM OVERLOARD

	// Gamepads
	public static final int gamepad1 = 1;
	public static final int gamepad2 = 2;

	// Motor safety timeout
	public static final int motorSafteyTimeout = 5;

	// Jaguars
	public static final int rightMotor1 = 2;
	public static final int rightMotor2 = 3;
	public static final int armMotor = 4;
	public static final int leftMotor1 = 5;
	public static final int leftMotor2 = 6;
	public static final int shooterMotor1 = 7;
	public static final int shooterMotor2 = 8;

	// Analog Modules
	public static final int armPotAnalog = 3;

	// Relays
	public static final int compresserRelay = 1;
	public static final int shooterRollerRelay = 2;
	public static final int armRollerRelay = 8;

	// Digital I/O
	public static final int pneumaticPreasureSwitch = 1;

	// Shooter
	public static final double speed1 = 0.65;
	public static final double speed2 = 0.73;
	public static final double speed3 = 0.79;
	public static final double speed4 = 1.0;

	// Pneumatics
	public static final int sole1Port = 1;
	public static final int sole2Port = 2;

	// Arm
	public static final boolean isManual = true;
	public static double armPosBottom = 2.14;
	public static double armPosStow = 2.47;

	public final static double Kp = 10;
	public final static double Ki = 0;
	public final static double Kd = 0;

}
