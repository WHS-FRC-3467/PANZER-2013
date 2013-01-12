package org.usfirst.frc0.subsystems;

import org.usfirst.frc0.OI;
import org.usfirst.frc0.RobotMap;
import org.usfirst.frc0.commands.driveBase.Drive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Do nothing here
		// Supposed to initialize the default command
		// here but i do it in the getInstance method
	}

	private static DriveBase instance = null;
	private RobotDrive drive;

	CANJaguar jag1;
	CANJaguar jag2;
	CANJaguar jag3;
	CANJaguar jag4;

	public static DriveBase getInstance() {
		if (instance == null) {
			instance = new DriveBase();
			instance.setDefaultCommand(new Drive());
		}
		return instance;
	}

	public DriveBase() {
		try {
			jag1 = new CANJaguar(RobotMap.rightMotor1);
			jag2 = new CANJaguar(RobotMap.rightMotor2);
			jag3 = new CANJaguar(RobotMap.leftMotor1);
			jag4 = new CANJaguar(RobotMap.leftMotor2);
		} catch (CANTimeoutException e) {
			System.out.println("JAGUARS: Failed to initialize jaguars");
			e.printStackTrace();
		}
		drive = new RobotDrive(jag1, jag2, jag3, jag4);
		drive.setSafetyEnabled(false); // to simplify explanation (not good practice)
	}

	public void driveRobot() {
		double left = OI.getInstance().getGamepad1().getLeftStickY();
		double right = OI.getInstance().getGamepad1().getRightStickY();
		drive.tankDrive(left, right);
	}

}
