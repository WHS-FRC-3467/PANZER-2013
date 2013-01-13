package org.usfirst.frc0.subsystems;

import org.usfirst.frc0.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	Solenoid sole1;
	Solenoid sole2;
	
	private static Pneumatics instance = null;

	public static Pneumatics getInstance() {
		if (instance == null) {
			instance = new Pneumatics();
		}
		return instance;
	}
	
	public Pneumatics() {
		sole1 = new Solenoid(RobotMap.sole1Port);
		sole2 = new Solenoid(RobotMap.sole2Port);
	}
	
	protected void initDefaultCommand() {
		//Keep it in whatever gear it was already in
	}

	public void shiftHigh() {
		sole2.set(true);
	}
	
	public void shiftLow() {
		sole1.set(true);
	}
	
	public void shiftOff() {
		sole1.set(false);
		sole2.set(false);
	}
}
