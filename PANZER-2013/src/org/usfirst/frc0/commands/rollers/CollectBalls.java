package org.usfirst.frc0.commands.rollers;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.ArmRoller;

public class CollectBalls extends CommandBase {
	ArmRoller armRollerSubsytem;

	public CollectBalls() {
		armRollerSubsytem = ArmRoller.getInstance();
		requires(armRollerSubsytem);
	}

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		armRollerSubsytem.forward();
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
