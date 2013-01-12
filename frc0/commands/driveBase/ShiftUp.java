
package org.usfirst.frc0.commands.driveBase;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.Pneumatics;

public class ShiftUp extends CommandBase {
	Pneumatics shiftingSubsystem;
    public ShiftUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	shiftingSubsystem = Pneumatics.getInstance();
    	requires(shiftingSubsystem);
    	setTimeout(0.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shiftingSubsystem.shiftHigh();
    }

 // Make this return true when this Command no longer needs to run execute()
 	protected boolean isFinished() {
 		return isTimedOut();
 	}

 	// Called once after isFinished returns true
 	protected void end() {
 		shiftingSubsystem.shiftOff();
 	}

 	// Called when another command which requires one or more of the same
 	// subsystems is scheduled to run
 	protected void interrupted() {
 		this.end();
 	}
 }
