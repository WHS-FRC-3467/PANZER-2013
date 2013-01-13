package org.usfirst.frc0.commands.driveBase;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.DriveBase;

public class Drive extends CommandBase {
	DriveBase driveSubsystem;

	public Drive() {
		driveSubsystem = DriveBase.getInstance();
		requires(driveSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		driveSubsystem.driveRobot();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
