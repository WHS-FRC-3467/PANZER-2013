package org.usfirst.frc0.subsystems;

import org.usfirst.frc0.RobotMap;
import org.usfirst.frc0.commands.arm.DynamicArm;
import org.usfirst.frc0.commands.arm.ManualArmControl;
import org.usfirst.frc0.commands.shooter.AdjustSpeed;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends PIDSubsystem {
	private static Arm instance = null;
	CANJaguar armJag;
	AnalogChannel pot;
	DriverStation ds = DriverStation.getInstance();

	public static Arm getInstance() {
		if (instance == null) {
			instance = new Arm();
		}
		return instance;
	}

	private final static double Kd = RobotMap.Kd;
	private final static double Kp = 0;
	private final static double Ki = 0;

	public void initDefaultCommand() {
		if (RobotMap.isManual)
			instance.setDefaultCommand(new ManualArmControl());
		else
			instance.setDefaultCommand(new DynamicArm());
	}
	public Arm() {
		super("Arm", Kp, Ki, Kd);
		try {
			armJag = new CANJaguar(RobotMap.armMotor);
			configJags();
		} catch (CANTimeoutException e) {
			System.out.println("JAGUARS: Failed to initialize arm jaguar");
			e.printStackTrace();
		}

		pot = new AnalogChannel(RobotMap.armPot);

		if (RobotMap.isManual) {
			System.out.println("Arm set to manual...");
			armJag.setSafetyEnabled(false);
		} else {
			System.out.println("Arm set to PID control...");
		}
	}

	public double returnPIDInput() {
		double voltage = pot.getVoltage();
		return voltage;
	}

	public void usePIDOutput(double output) {

		try {
			if (armJag.getPowerCycled())
				configJags();
		} catch (CANTimeoutException e) {
			e.printStackTrace();
		}

		if (output > .95)
			output = 0.95;
		if (output < -.95)
			output = -0.95;

		try {
			armJag.setX(output);
		} catch (CANTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void configJags() {
		try {
			armJag.configNeutralMode(CANJaguar.NeutralMode.kBrake);
			armJag.setExpiration(RobotMap.motorSafteyTimeout);
			armJag.configFaultTime(0.5);
		} catch (CANTimeoutException e) {
			e.printStackTrace();
		}
	}

	public void directDrive(float input) {
		try {
			armJag.setX(input);
		} catch (CANTimeoutException e) {
			e.printStackTrace();
		}
	}
}
