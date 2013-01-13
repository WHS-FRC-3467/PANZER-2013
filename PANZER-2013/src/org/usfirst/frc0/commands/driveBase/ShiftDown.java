package org.usfirst.frc0.commands.driveBase;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.Pneumatics;

public class ShiftDown extends CommandBase {
	Pneumatics shiftingSubsystem;

	public ShiftDown() {
		shiftingSubsystem = Pneumatics.getInstance();
		requires(shiftingSubsystem);
		setTimeout(0.1);
	}

	protected void initialize() {
	}

	protected void execute() {
		shiftingSubsystem.shiftLow();
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
