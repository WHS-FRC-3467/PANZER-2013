package org.usfirst.frc0.commands.rollers;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.ShooterRoller;

public class RejectShoot extends CommandBase {
	ShooterRoller shooterRollerSubsystem;

	public RejectShoot() {
		shooterRollerSubsystem = ShooterRoller.getInstance();
		requires(shooterRollerSubsystem);
	}

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		shooterRollerSubsystem.reverse();
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
