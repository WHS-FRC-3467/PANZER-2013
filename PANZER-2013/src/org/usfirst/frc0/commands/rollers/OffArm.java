package org.usfirst.frc0.commands.rollers;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.ArmRoller;

public class OffArm extends CommandBase {
	ArmRoller armRollerSubsystem;
	public OffArm() {
		armRollerSubsystem = ArmRoller.getInstance();
		requires(armRollerSubsystem);
	}
	
	
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		armRollerSubsystem.off();
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
