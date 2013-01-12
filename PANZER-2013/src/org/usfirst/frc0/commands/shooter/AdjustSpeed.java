
package org.usfirst.frc0.commands.shooter;

import org.usfirst.frc0.commands.CommandBase;
import org.usfirst.frc0.subsystems.Shooter;
   
public class AdjustSpeed extends CommandBase {
	Shooter shooterSubsystem;
	double shooterSpeed;
    public AdjustSpeed(double speed) {
    	shooterSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	shooterSubsystem = Shooter.getInstance();
    	requires(shooterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooterSubsystem.setSpeed(shooterSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
