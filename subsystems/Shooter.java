package org.usfirst.frc0.subsystems;

import org.usfirst.frc0.RobotMap;
import org.usfirst.frc0.commands.shooter.AdjustSpeed;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Do nothing here
		// Supposed to initialize the default command
		// here but i do it in the getInstance method
	}

	private static Shooter instance = null;
	private RobotDrive drive;

	CANJaguar jag1;
	CANJaguar jag2;

	DriverStation ds = DriverStation.getInstance();

	public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
			instance.setDefaultCommand(new AdjustSpeed(0));
		}
		return instance;
	}

	public Shooter() {
		try {
			jag1 = new CANJaguar(RobotMap.shooterMotor1);
			jag2 = new CANJaguar(RobotMap.shooterMotor2);
			jag1.configNeutralMode(CANJaguar.NeutralMode.kCoast);
			jag2.configNeutralMode(CANJaguar.NeutralMode.kCoast);
		} catch (CANTimeoutException e) {
			System.out.println("JAGUARS: Failed to initialize jaguars");
			e.printStackTrace();
		}
		drive = new RobotDrive(jag1, jag2);
		drive.setSafetyEnabled(false); // to simplify explanation (not good practice)
	}

	public void setSpeed(double rawSpeed) {
		float voltage = (float) ds.getBatteryVoltage();
		// Here is where we normalize the commanded speed, based on the current battery voltage
		double speed = (rawSpeed * 11.5) / voltage;

		if (speed > 0.99) {
			speed = 0.99;
		} else if (speed < 0.0) {
			speed = 0.0;
		}
		
		try {
			jag1.setX(speed);
			jag2.setX(speed);
		} catch (CANTimeoutException e) {
			e.printStackTrace();
		}
	}
}
