package org.usfirst.frc0.commands.arm;

import org.usfirst.frc0.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropArm extends CommandGroup {
	public DropArm() {
		addParallel(new SetArmPos(RobotMap.armPosBottom));
	}
}
