package org.usfirst.frc0.subsystems;

import org.usfirst.frc0.RobotMap;
import org.usfirst.frc0.commands.rollers.OffArm;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmRoller extends Subsystem {

	protected void initDefaultCommand() {
		// Do nothing here
		// Supposed to initialize the default command
		// here but i do it in the getInstance method
	}

	private static ArmRoller instance = null;
	Relay feedmotor = new Relay(RobotMap.armRollerSpikePort,Relay.Direction.kBoth);

	public static ArmRoller getInstance() {
		if (instance == null) {
			instance = new ArmRoller();
			instance.setDefaultCommand(new OffArm());
		}
		return instance;
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
