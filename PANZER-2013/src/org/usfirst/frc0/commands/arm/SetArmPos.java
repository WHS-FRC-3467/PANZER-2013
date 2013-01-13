package org.usfirst.frc0.commands.arm;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.Arm;

public class SetArmPos extends CommandBase {
	Arm armSubsytem;
	double armPosition;

	public SetArmPos(double armPos) {
		armSubsytem = Arm.getInstance();
		requires(armSubsytem);
		armPosition = armPos;
	}

	protected void initialize() {
		armSubsytem.setSetpoint(armPosition);
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		if (Math.abs(Arm.getInstance().getPosition() - armPosition) < 0.05)
			return true;
		else
			return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
