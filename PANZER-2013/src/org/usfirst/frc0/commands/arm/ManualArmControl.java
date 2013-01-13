package org.usfirst.frc0.commands.arm;

import org.usfirst.frc0.OI;
import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.Arm;

public class ManualArmControl extends CommandBase {
	Arm armSubsytem;

	public ManualArmControl() {
		armSubsytem = Arm.getInstance();
		requires(armSubsytem);
	}

	protected void initialize() {

	}

	protected void execute() {
		armSubsytem.directDrive((float) OI.getInstance().getOperatorGampad().getRightStickY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
