package org.usfirst.frc0.commands.arm;

import org.usfirst.frc0.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StowArm extends CommandGroup {
	public StowArm() {
		addParallel(new SetArmPos(RobotMap.armPosStow));
	}
}