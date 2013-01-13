package org.usfirst.frc0.subsystems;

import org.usfirst.frc0.RobotMap;
import org.usfirst.frc0.commands.rollers.OffArm;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmRoller extends Subsystem {

	private static ArmRoller instance = null;
	Relay feedmotor = new Relay(RobotMap.armRollerRelay, Relay.Direction.kBoth);

	public static ArmRoller getInstance() {
		if (instance == null) {
			instance = new ArmRoller();
		}
		return instance;
	}

	protected void initDefaultCommand() {
		instance.setDefaultCommand(new OffArm());
	}

	public void off() {
		feedmotor.set(Relay.Value.kOff);
	}

	public void forward() {
		feedmotor.set(Relay.Value.kReverse);
	}

	public void reverse() {
		feedmotor.set(Relay.Value.kForward);
	}
}
