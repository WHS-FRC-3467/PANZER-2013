package org.usfirst.frc0.commands.rollers;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.ShooterRoller;

public class OffShooter extends CommandBase {
	ShooterRoller shooterRollerSubsystem;

	public OffShooter() {
		shooterRollerSubsystem = ShooterRoller.getInstance();
		requires(shooterRollerSubsystem);
	}

	protected void initialize() {

	}

	protected void execute() {
		shooterRollerSubsystem.off();
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
