package org.usfirst.frc0.commands.driveBase;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.Pneumatics;

public class ShiftUp extends CommandBase {
	Pneumatics shiftingSubsystem;

	public ShiftUp() {
		shiftingSubsystem = Pneumatics.getInstance();
		requires(shiftingSubsystem);
		setTimeout(0.1);
	}

	protected void initialize() {
	}

	protected void execute() {
		shiftingSubsystem.shiftHigh();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		shiftingSubsystem.shiftOff();
	}

	protected void interrupted() {
		this.end();
	}
}
