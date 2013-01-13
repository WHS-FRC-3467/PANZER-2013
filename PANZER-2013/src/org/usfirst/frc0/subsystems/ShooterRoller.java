package org.usfirst.frc0.subsystems;

import org.usfirst.frc0.RobotMap;
import org.usfirst.frc0.commands.rollers.OffShooter;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterRoller extends Subsystem {

	protected void initDefaultCommand() {
		// Do nothing here
		// Supposed to initialize the default command
		// here but i do it in the getInstance method
	}

	private static ShooterRoller instance = null;
	Relay feedmotor = new Relay(RobotMap.shooterRollerRelay, Relay.Direction.kBoth);

	public static ShooterRoller getInstance() {
		if (instance == null) {
			instance = new ShooterRoller();
			instance.setDefaultCommand(new OffShooter());
		}
		return instance;
	}

	public void off() {
		feedmotor.set(Relay.Value.kOff);
	}

	public void forward() {
		feedmotor.set(Relay.Value.kForward);
	}

	public void reverse() {
		feedmotor.set(Relay.Value.kReverse);
	}
}
