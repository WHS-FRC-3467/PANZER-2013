package org.usfirst.frc0.commands.arm;

import org.usfirst.frc0.OI;
import org.usfirst.frc0.RobotMap;
import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.Arm;

public class DynamicArm extends CommandBase {
	Arm armSubsytem;

	public DynamicArm() {
		armSubsytem = Arm.getInstance();
		requires(armSubsytem);
	}

	protected void initialize() {

	}

	protected void execute() {
		double opY = OI.getInstance().getOperatorGampad().getRightStickY();
		if (opY < 0) {
			opY = 0;
		}
		opY = RobotMap.armPosStow - (RobotMap.armPosStow - RobotMap.armPosBottom) * opY;
		armSubsytem.setSetpoint(opY);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
