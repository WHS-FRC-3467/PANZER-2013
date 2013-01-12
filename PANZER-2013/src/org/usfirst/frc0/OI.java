package org.usfirst.frc0;

import org.usfirst.frc0.commands.driveBase.ShiftDown;
import org.usfirst.frc0.commands.driveBase.ShiftUp;
import org.usfirst.frc0.commands.rollers.CollectBalls;
import org.usfirst.frc0.commands.rollers.RejectBalls;
import org.usfirst.frc0.commands.rollers.RejectShoot;
import org.usfirst.frc0.commands.rollers.Shoot;
import org.usfirst.frc0.commands.shooter.AdjustSpeed;
import org.usfirst.frc0.peripherals.Gamepad;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//Process operator interface input here .
public class OI {

	private static OI instance;

	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}

	//Rawr
	
	// Create and return gamepad values
	private Gamepad gamepad1 = new Gamepad(RobotMap.gamepad1);
	private Gamepad gamepad2 = new Gamepad(RobotMap.gamepad2);

	public Gamepad getGamepad1() {
		return gamepad1;
	}

	public Gamepad getGamepad2() {
		return gamepad2;
	}

	// Create buttons for the driver gamepad
	Button driverLeftBumper = new JoystickButton(gamepad1, Gamepad.leftBumber); //Shift Down
	Button driverRightBumper = new JoystickButton(gamepad1, Gamepad.rightBumper); //Shift Up
	Button driverLeftStickButton = new JoystickButton(gamepad1, Gamepad.leftStickPress); //Alternative Shift Down
	Button driverRightStickButton = new JoystickButton(gamepad1, Gamepad.rightStickPress); //Alternative Shift Up

	// Create buttons for the operator gamepad
	Button oppXButton = new JoystickButton(gamepad2, Gamepad.xButton);
	Button oppAButton = new JoystickButton(gamepad2, Gamepad.aButton);
	Button oppBButton = new JoystickButton(gamepad2, Gamepad.bButton);
	Button oppYButton = new JoystickButton(gamepad2, Gamepad.yButton);
	Button oppStartButton = new JoystickButton(gamepad2, Gamepad.startButton);
	Button oppLeftBumper = new JoystickButton(gamepad2, Gamepad.leftBumber);
	Button oppRightBumper = new JoystickButton(gamepad2, Gamepad.rightBumper);
	Button oppLeftTrigger = new JoystickButton(gamepad2, Gamepad.leftTrigger);
	Button oppRightTrigger = new JoystickButton(gamepad2, Gamepad.rightTrigger);
	
	public OI() {
		//Set buttons for driver gamepad
		
		//Shifting
		driverLeftBumper.whenPressed(new ShiftDown());
		driverRightBumper.whenPressed(new ShiftUp()); 
		driverLeftStickButton.whenPressed(new ShiftDown());
		driverRightStickButton.whenPressed(new ShiftUp());
		
		//Set buttons for operator gamepad
		
		//Speed of shooter
		oppXButton.whenPressed(new AdjustSpeed(RobotMap.speed1));
		oppAButton.whenPressed(new AdjustSpeed(RobotMap.speed2));
		oppBButton.whenPressed(new AdjustSpeed(RobotMap.speed3));
		oppYButton.whenPressed(new AdjustSpeed(RobotMap.speed4));
		oppStartButton.whenPressed(new AdjustSpeed(0)); //Shut off shooter
		
		//Rollers
		oppLeftBumper.whileHeld(new Shoot());
		oppRightBumper.whileHeld(new CollectBalls());
		oppLeftTrigger.whileHeld(new RejectShoot());
		oppRightTrigger.whileHeld(new RejectBalls());
	}
}
